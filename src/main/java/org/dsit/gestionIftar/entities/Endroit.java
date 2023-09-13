package org.dsit.gestionIftar.entities;

import javax.persistence.*;
@Entity
public class Endroit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String adress;
	@ManyToOne()
	private Annexe aal;
	@ManyToOne()
	private District district;
	private int superficie;
	private String contact;
	private String observations;
	private int x;
	private int y;
	@ManyToOne()
	private Categorie categorie;
	public Endroit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endroit(String adress, int superficie, String contact, String observations, int x, int y) {
		super();
		this.adress = adress;
		this.superficie = superficie;
		this.contact = contact;
		this.observations = observations;
		this.x = x;
		this.y = y;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Annexe getAal() {
		return aal;
	}
	public void setAal(Annexe aal) {
		this.aal = aal;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
