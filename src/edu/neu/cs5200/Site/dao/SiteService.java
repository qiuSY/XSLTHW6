package edu.neu.cs5200.Site.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.neu.cs5200.Site.models.Site;


@Path("/api/site")
public class SiteService {

	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public  List<Site> createSite(Site Site)
	{
		SiteDAO dao=new SiteDAO();
		dao.createSite(Site);
		return dao.findAllSites();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite (@PathParam("id") int siteId,Site site)
	{
		SiteDAO dao=new SiteDAO();
		dao.updateSite(siteId,site);
		return dao.findAllSites();
	}
	
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite (@PathParam("id")int siteId)
	{
		SiteDAO dao=new SiteDAO();
		 dao.removeSite(siteId);
		return dao.findAllSites();
	}


	
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	//public List<Site> f​indAllSites(​)
	public List<Site> findAllSites()
	{		
		SiteDAO dao=new SiteDAO();
		return dao.findAllSites();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id")int siteId)
	{
		SiteDAO dao=new SiteDAO();
		return dao.findSite(siteId);
	}
	
	
}
