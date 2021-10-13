package com.askamservices.gestionEtabScolaireWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askamservices.gestionEtabScolaireWeb.model.Etudiant;
import com.askamservices.gestionEtabScolaireWeb.repository.EtudiantRepository;

/**
 * @author HP
 *
 */
@Service
public class EtudiantService {
	
	@Autowired
	private EtudiantRepository etudiantRepos;
	
	/**
	 * @return All students in database
	 *
	 */
	public List<Etudiant> getEtudiants(){
		
		return etudiantRepos.findAll();
	}
	
	/**
	 * @param id The id of the student who should find
	 * 
	 * @return An student by this id
	 *
	 */
	public Etudiant getEtudiant(Long id) {
		
		return etudiantRepos.findById(id).get();
	}
	
	/**
	 * @param etudiant The student to save in database
	 * 
	 * @return An student saved in database
	 *
	 */
	public Etudiant saveEtudiant(Etudiant etudiant) {
		
		etudiant.setNom(etudiant.getNom().toUpperCase());
		
		return etudiantRepos.save(etudiant);
	}
	
	/**
	 * @param id The id of the student to delete in database
	 * 
	 * @return void
	 *
	 */
	public void deleteEtudiant(Long id) {
		
		etudiantRepos.deleteById(id);
	}
}
