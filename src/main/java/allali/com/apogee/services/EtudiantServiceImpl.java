package allali.com.apogee.services;

import allali.com.apogee.entities.*;
import allali.com.apogee.entities.Module;
import allali.com.apogee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    FillièreRepository fillièreRepository;

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public void updateEtudiant(Etudiant etudiant, Long id) {
        Etudiant etudiant1 = etudiantRepository.findById(id).orElse(null);
        etudiant1.setNom(etudiant.getNom());
        etudiant1.setPrenom(etudiant.getPrenom());
        etudiant1.setFilliere(etudiant.getFilliere());
        etudiant1.setDateDeNaissance(etudiant.getDateDeNaissance());
        etudiant1.setNotes(etudiant.getNotes());
        etudiant1.setModuleList(etudiant.getModuleList());
        etudiantRepository.save(etudiant1);
    }

    public Etudiant rechercher(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        return etudiant;
    }

    public List<Etudiant> etudiantList() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return etudiants;
    }

    // Professeur
    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    public Professeur rechercherProfesseur(Long id) {
        Professeur professeur = professeurRepository.findById(id).orElse(null);
        return professeur;
    }

    public List<Professeur> listProfesseur() {
        List<Professeur> professeurList = professeurRepository.findAll();
        return professeurList;
    }

    public void supprimerProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }

    //Modifier Professeur
    // Filliére
    public void ajouterFillière(Fillière filliere) {
        fillièreRepository.save(filliere);
    }

    public void supprimerFillière(Long id) {
        fillièreRepository.deleteById(id);
    }

    public Fillière rechercherFillière(Long id) {
        Fillière filliere = fillièreRepository.findById(id).orElse(null);
        return filliere;

    }

    public List<Fillière> fillièreList() {
        List<Fillière> filliereList = fillièreRepository.findAll();
        return filliereList;
    }

    //Modifier une filliére
    // Modules
    public void ajouterModule(Module module) {
        moduleRepository.save(module);
    }

    public void supprimerModule(Long id) {
        moduleRepository.deleteById(id);
    }

    public Module rechercherModule(Long id) {
        Module module = moduleRepository.findById(id).orElse(null);
        return module;
    }

    public List<Module> moduleList() {
        List<Module> moduleList = moduleRepository.findAll();
        return moduleList;
    }

    //Modifier un module
    // Notes
    public void ajouterNote(Note note) {
        noteRepository.save(note);
    }

    public void supprimerNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note rechercherNote(Long id) {
        Note note = noteRepository.findById(id).orElse(null);
        return note;
    }

    public List<Note> noteList() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    //Modifier une note
    //Ajouter des etudiant a une filliere
    public void ajouterEtudiantToFillière(Long id, Long idd) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        Fillière filliere = fillièreRepository.findById(idd).orElse(null);
        etudiant.setFilliere(filliere);
        filliere.getList().add(etudiant);
        etudiantRepository.save(etudiant);
        fillièreRepository.save(filliere);

    }

    //Ajouter des professeur a une fillier


    //Ajouter des modules a une filliere
    public void ajouterModuleToFillière(Long id, Long idd) {
        Module module = moduleRepository.findById(id).orElse(null);
        Fillière filliere = fillièreRepository.findById(idd).orElse(null);
        module.setFilliere(filliere);
        filliere.getModuleList().add(module);
        moduleRepository.save(module);
        fillièreRepository.save(filliere);

    }

    //Ajouter des etudiant a des modules
    public void ajouterEtudiantToModule(Long id, Long idd) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        Module module = moduleRepository.findById(idd).orElse(null);
        etudiant.getModuleList().add(module);
        module.getEtudiantList().add(etudiant);
        etudiantRepository.save(etudiant);
        moduleRepository.save(module);

    }

    //Ajouter des profs a des modules
    public void ajouterProfesseurToModule(Long id, Long idd) {
        Professeur professeur = professeurRepository.findById(id).orElse(null);
        Module module = moduleRepository.findById(idd).orElse(null);
        professeur.getModulelist().add(module);
        module.setProfesseur(professeur);
        professeurRepository.save(professeur);
        moduleRepository.save(module);
    }

    //Ajouter des notes a des etudiants ******************************************************
    public void ajouterNotesToEtudiant(Long id, Long idd) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        Fillière filliere = fillièreRepository.findById(idd).orElse(null);
        etudiant.setFilliere(filliere);
        filliere.getList().add(etudiant);
        etudiantRepository.save(etudiant);
        fillièreRepository.save(filliere);

    }
}
    //Ajouter des note a des modules
    /*public void ajouterEtudiantToFillière(Long id , Long idd){
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        Fillière fillière = fillièreRepository.findById(idd).orElse(null);
        etudiant.setFillière(fillière);
        fillière.getList().add(etudiant);
        etudiantRepository.save(etudiant);
        fillièreRepository.save(fillière);

    }*/
    //calculer la moyenne  d'un etudiant
    /*public void ajouterEtudiantToFillière(Long id , Long idd){
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        Fillière fillière = fillièreRepository.findById(idd).orElse(null);
        etudiant.setFillière(fillière);
        fillière.getList().add(etudiant);
        etudiantRepository.save(etudiant);
        fillièreRepository.save(fillière);
*/

    //

