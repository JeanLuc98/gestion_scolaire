package com.askamservices.gestionEtabScolaireWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directeur")
public class Directeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String téléphone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTéléphone() {
		return téléphone;
	}
	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}
	
	public Directeur() {
		super();
	}
	
	public Directeur(String matricule, String nom, String prenom, String email, String adresse, String téléphone) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.téléphone = téléphone;
	}
	
	@Override
	public String toString() {
		return "Directeur [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", adresse=" + adresse + ", téléphone=" + téléphone + "]";
	}
	
	
}
