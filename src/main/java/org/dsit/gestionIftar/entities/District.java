package org.dsit.gestionIftar.entities;

import java.util.List;
import javax.persistence.*;





@Entity
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@OneToMany(mappedBy = "district")
	private List<Annexe> annexes;
	@OneToMany(mappedBy = "district")
	private List<Endroit> endroits;
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(String designation) {
		super();
		this.designation = designation;
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


	public List<Endroit> getEndroits() {
		return endroits;
	}

	public void setEndroits(List<Endroit> endroits) {
		this.endroits = endroits;
	}

	public List<Annexe> getAnnexes() {
		return annexes;
	}

	public void setAnnexes(List<Annexe> annexes) {
		this.annexes = annexes;
	}
	
	
}
