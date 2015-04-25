package edu.neu.cs5200.Site.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String latitude;
	@XmlAttribute
	private String longitude;
	
	//Assume they have one to many relationship
	@OneToMany(mappedBy="site")//reference in other table
	@XmlElement(name="tower")
	private List<Tower> towers;//the tower who have the foreign key to site
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public Site(Integer id, String name, String latitude, String longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Site() {
		super();
	}

	
	
}
