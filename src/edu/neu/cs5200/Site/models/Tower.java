package edu.neu.cs5200.Site.models;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import org.codehaus.jackson.annotate.JsonBackReference;



@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
//@Table(name=tower)class name does not match the table name
public class Tower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private Float height;
	@XmlAttribute
	private String sides;
	
	//do not have foreign key in this class
	@OneToMany(mappedBy="tower")//reference in other table
	@XmlElement(name="equipment")
	private List<Equipment> equipments;//the tower who have the foreign key to site

	
	//Assume they have manytoone relationship
	//reference to Site,we are many side
	//EAGER,when you fetch site, fetch all tower
	//And what is the field we are going to join
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="siteId")
	@XmlTransient
	
	private Site site;


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


	public Float getHeight() {
		return height;
	}


	public void setHeight(Float height) {
		this.height = height;
	}


	public String getSides() {
		return sides;
	}


	public void setSides(String sides) {
		this.sides = sides;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public List<Equipment> getEquipments() {
		return equipments;
	}


	public void setEquipments(List<Equipment> equipment) {
		this.equipments = equipment;
	}


	public Tower() {
		super();
	}


	public Tower(Integer id, String name, Float height, String sides, Site site) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
	}
}
