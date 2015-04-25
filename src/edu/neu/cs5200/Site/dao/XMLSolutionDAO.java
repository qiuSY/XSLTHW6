package edu.neu.cs5200.Site.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.persistence.*;

import edu.neu.cs5200.Site.models.Site;
import edu.neu.cs5200.Site.xml.SiteList;

public class XMLSolutionDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Site");
	EntityManager em = factory.createEntityManager();
	
	//public List<Site> f​indAllSites(​)
	public List<Site> findAllSites()
	{
		Query selectAll = em.createQuery("select site from Site site");
		return selectAll.getResultList();
	}
	
	public void exportDirectorsToXmlFile(SiteList sites, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sites, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void convertXmlFileToOutputFile(
			String sitelistXmlFileName,
			String outputFileName,
			String xsltFileName)
	{
		File inputXmlFile = new File(sitelistXmlFileName);
		File outputXmlFile = new File(outputFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void main(String[] args) {
		XMLSolutionDAO dao = new XMLSolutionDAO();
		List<Site> sites = dao.findAllSites();

		SiteList thesites = new SiteList();
		thesites.setSites(sites);
		
		dao.exportDirectorsToXmlFile(thesites, "xml/sites.xml");
//		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");


	}
}
