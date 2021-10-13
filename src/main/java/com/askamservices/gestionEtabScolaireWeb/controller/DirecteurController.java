 package com.askamservices.gestionEtabScolaireWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.askamservices.gestionEtabScolaireWeb.model.Etudiant;
import com.askamservices.gestionEtabScolaireWeb.service.EtudiantService;

@Controller
public class DirecteurController {
	
	@Autowired
	EtudiantService etudiantService;

	@GetMapping("/")
	public String espaceDirecteur(Model model){
		
		List<Etudiant> listeEtudiant = etudiantService.getEtudiants();
		model.addAttribute("etudiants", listeEtudiant);
		
		return "espaceDirecteur";
	}
	
	/**
	 * Create an student
	 * 
	 * */
	@GetMapping("/creerEtudiant")
	public String createEtudiant(Model model) {
		
		Etudiant etudiant = new Etudiant();
		model.addAttribute("etudiant", etudiant);
		
		return "createEtudiant";
	}
	
	@GetMapping("/updateEtudiant/{id}")
	public String updateEtudiant(@PathVariable("id") final Long id, Model model) {
		
		Etudiant e = etudiantService.getEtudiant(id);	
		
		model.addAttribute("etudiant", e);	
		
		return "formUpdateEtudiant";		
	}
		@PutMapping("/modifierEtudiant")
		public Etudiant studentToUpdate(@RequestBody Etudiant etudiant) {
		
		Etudiant e = etudiantService.getEtudiant(etudiant.getId());
		
		if (e != null) {
			
			Etudiant currentEtudiant = e;
			
			String prenom = etudiant.getPrenom();
			if (prenom != null) {
				currentEtudiant.setPrenom(prenom);
			}
			
			String nom = etudiant.getNom();
			if (nom != null) {
				currentEtudiant.setNom(nom);
			}
			
			String dateNaiss = etudiant.getDateNaissance();
			if (dateNaiss != null) {
				currentEtudiant.setDateNaissance(dateNaiss);
			}
			
			String email = etudiant.getEmail();
			if (email != null) {
				currentEtudiant.setEmail(email);
			}
			
			String tel = etudiant.getTelephone();
			if (tel != null) {
				currentEtudiant.setTelephone(tel);
			}
			
			String adresse = etudiant.getAdresse();
			if (adresse != null) {
				currentEtudiant.setAdresse(adresse);
			}
			
			etudiantService.saveEtudiant(currentEtudiant);
			
			return currentEtudiant;
			
		} else {
			return null;
		}
	}

	
	/**
	 * add a new student in database after create him
	 * 
	 * */
	@PostMapping("/saveEtudiant")
	public ModelAndView saveEtudiant(@ModelAttribute Etudiant etudiant) {
			
		if (etudiant.getId() != null) {
			studentToUpdate(etudiant);
		} else {

			etudiantService.saveEtudiant(etudiant);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteEtudiant(@PathVariable("id") final Long id) {
		
		etudiantService.deleteEtudiant(id);
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/listeEtudiants")
	public String listeEtudiants(Model model) {
		
		List<Etudiant> listeEtudiant = etudiantService.getEtudiants();
		model.addAttribute("etudiants", listeEtudiant);
		
		return "listeEtudiants";
	}
	
	@GetMapping("/update")
	public String modifierEtudiant(Model model) {
		
		List<Etudiant> listeEtudiant = etudiantService.getEtudiants();
		model.addAttribute("etudiants", listeEtudiant);
		
		return "modifierEtudiant";
	}
	
	@GetMapping("/delete")
	public String supprimerEtudiant(Model model) {
		
		List<Etudiant> listeEtudiant = etudiantService.getEtudiants();
		model.addAttribute("etudiants", listeEtudiant);
		
		return "supprimerEtudiant";
	}
}
