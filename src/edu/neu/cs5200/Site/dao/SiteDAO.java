package edu.neu.cs5200.Site.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.Site.models.Equipment;
import edu.neu.cs5200.Site.models.Site;
import edu.neu.cs5200.Site.models.Tower;


//Assume all one to many relationship are on delete and update cascade

public class SiteDAO {
	
	private static Object tower;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Site");
	EntityManager em = factory.createEntityManager();
	
	
	//public Site f​indSite(​int siteId)
	public Site findSite(int siteId)
	{
		return em.find(Site.class, siteId);
	}
	
	
	//Test
	//public Tower findTower(int towerId)
	public Tower findTower(int towerId)
	{
		return em.find(Tower.class, towerId);
	}
	
	
	//public List<Site> f​indAllSites(​)
	public List<Site> findAllSites()
	{
		Query selectAll = em.createQuery("select site from Site site");
		return selectAll.getResultList();
	}
	
	//public List<Site> ​updateSite(​int siteId, Site site)
	public void updateSite (int siteId,Site site)
	{
//		List<Site> sites = new ArrayList<Site>();
		em.getTransaction().begin();

		site.setId(siteId);
		em.merge(site);
		
//		Query query=em.createQuery("select site from Site site");
//		sites=query.getResultList();
		
		em.getTransaction().commit();
		em.close();
//		return sites;
	}
	
	//public List<Site> r​emoveSite(​int siteId)
	public List<Site> removeSite (int siteId)
	{
		List<Site> sites = new ArrayList<Site>();
		
		Site site=null;
		
		em.getTransaction().begin();

		site = em.find(Site.class, siteId);
		em.remove(site);
		
		Query query=em.createQuery("select site from Site site");
		sites=query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return sites;
	}
	
	//public List<Site> ​createSite(​Site site) 
	
	public List<Site> createSite (Site site)
	{
		List<Site> sites = new ArrayList<Site>();
				
		em.getTransaction().begin();

		em.persist(site);
		
		Query query=em.createQuery("select site from Site site");
		sites=query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return sites;
	}
//Test	
	public void addTower(Integer siteId, Tower tower)
	{
		em.getTransaction().begin();
		Site site= em.find( Site.class, siteId);
		tower.setSite(site);
		site.getTowers().add(tower);
		em.merge(site);
		em.getTransaction().commit();
	}
//Test
	public void addEquipment(Integer towerId, Equipment equipment)
	{
		em.getTransaction().begin();
		Tower tower= em.find(Tower.class, towerId);
		equipment.setTower(tower);
		tower.getEquipments().add(equipment);
		em.merge(tower);
		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		SiteDAO dao = new SiteDAO();
		
	/*
		Site site = dao.findSite(1);
		System.out.println(site.getName());
		System.out.println(site.getTowers().size());
		
		List<Tower> towers=site.getTowers();
		for(Tower tower:towers)
			System.out.println(tower.getName());
		*/
		
	/*	Tower tower = dao.findTower(1);
		System.out.println(tower.getName());
		System.out.println(tower.getEquipments().size());
		
		List<Equipment> equipments=tower.getEquipments();
		for(Equipment equipment:equipments)
			System.out.println(equipment.getName());
		*/
		/*
		
		List<Site> sites = dao.findAllSites();
		for(Site site : sites)
		{
			System.out.println(site.getName());
		}
	*/
//		
		Site site = new Site();
		site.setName("hdsadasa");
		site.setLatitude("1111111111112222222");
		dao.updateSite(33, site);
//		
		
		//dao.removeSite(2);
		/*Site site = new Site(null, "Alsbjkb", "Plot", "Poster");
		dao.createSite(site);
*/
//		Tower tower=new Tower(null,"hdasdsahu",(float) 8.1,"dada",null);
//		dao.addTower(24, tower);
		
/*		
		Equipment equipment=new Equipment(null,"hdasdsahu","aa","dada",(float)2.1,null);
		dao.addEquipment(1, equipment);
	*/	
	}

}
