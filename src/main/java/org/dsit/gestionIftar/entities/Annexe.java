package org.dsit.gestionIftar.entities;

import java.util.List;

import javax.persistence.*;



@Entity
public class Annexe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@ManyToOne()
	private District district;
	@OneToMany(mappedBy = "aal")
	private List<Endroit> endroits;
	public Annexe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annexe(String designation ,District distric) {
		super();
		
		this.designation = designation;
		this.district = distric;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public District getDistrict() {
		return district;
	}
	
	public List<Endroit> getEndroits() {
		return endroits;
	}
	public void setEndroits(List<Endroit> endroits) {
		this.endroits = endroits;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	
}
