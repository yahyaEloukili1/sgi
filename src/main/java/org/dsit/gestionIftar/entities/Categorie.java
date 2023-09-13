package org.dsit.gestionIftar.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Categorie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String designation;
	@OneToMany(mappedBy = "categorie")
	private List<Endroit> endroits;
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
	public List<Endroit> getEndroits() {
		return endroits;
	}
	
	public void setEndroits(List<Endroit> endroits) {
		this.endroits = endroits;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String designation) {
		super();
		this.designation = designation;
	
	}
	
}
