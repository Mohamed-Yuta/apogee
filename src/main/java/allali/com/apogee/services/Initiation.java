package allali.com.apogee.services;

import allali.com.apogee.entities.*;
import allali.com.apogee.entities.Module;
import allali.com.apogee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class Initiation {
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    FillièreRepository fillièreRepository;

    public void Initiation() {
        Fillière filliere = new Fillière();
        filliere.setNom("Informatique");
        fillièreRepository.save(filliere);

        // Créer un professeur
        Professeur professeur = new Professeur();
        professeur.setNom("Cherkaoui");
        professeur.setPrenom("Wafae");
        professeur.setDateNaissance(new Date());
        professeur.setTel("0123456789");
        professeur.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur);
        Professeur professeur2 = new Professeur();
        professeur2.setNom("Mahboub");
        professeur2.setPrenom("Aziz");
        professeur2.setDateNaissance(new Date());
        professeur2.setTel("0123456789");
        professeur2.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur2);
        Professeur professeur3 = new Professeur();
        professeur3.setNom("Elidrissi");
        professeur3.setPrenom("Najlae");
        professeur3.setDateNaissance(new Date());
        professeur3.setTel("0123456789");
        professeur3.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur3);
        Professeur professeur4 = new Professeur();
        professeur4.setNom("Ouafae");
        professeur4.setPrenom("Baida");
        professeur4.setDateNaissance(new Date());
        professeur4.setTel("0123456789");
        professeur4.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur4);
        Professeur professeur5 = new Professeur();
        professeur5.setNom("Elayachi");
        professeur5.setPrenom("Mohamed");
        professeur5.setDateNaissance(new Date());
        professeur5.setTel("0123456789");
        professeur5.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur5);
        Professeur professeur6 = new Professeur();
        professeur6.setNom("Baslam");
        professeur6.setPrenom("Jawad");
        professeur6.setDateNaissance(new Date());
        professeur6.setTel("0123456789");
        professeur6.setAdresse("AdresseProfesseur");
        professeurRepository.save(professeur6);

        // Créer un module avec le professeur et la filière
        Module module = new Module();
        module.setNom("Mathématiques");
        module.setProfesseur(professeur);
        module.setFilliere(filliere);
        professeur.getModulelist().add(module);

        moduleRepository.save(module);
        Module module2 = new Module();
        module2.setNom("Tec");
        module2.setProfesseur(professeur2);
        module2.setFilliere(filliere);
        moduleRepository.save(module2);
        Module module3 = new Module();
        module3.setNom("SI");
        module3.setProfesseur(professeur4);
        module3.setFilliere(filliere);
        moduleRepository.save(module3);
        Module module4 = new Module();
        module4.setNom("Reseaux");
        module4.setProfesseur(professeur6);
        module4.setFilliere(filliere);
        moduleRepository.save(module4);
        Module module5 = new Module();
        module5.setNom("JAVA");
        module5.setProfesseur(professeur5);
        module5.setFilliere(filliere);
        moduleRepository.save(module5);


        // Créer un étudiant avec la filière
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Allali");
        etudiant.setPrenom("Mohamed Amine");
        etudiant.setDateDeNaissance(new Date());
        etudiant.setFilliere(filliere);
        etudiantRepository.save(etudiant);
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNom("Aababou");
        etudiant1.setPrenom("Ahmed");
        etudiant1.setDateDeNaissance(new Date());
        etudiant1.setFilliere(filliere);
        etudiantRepository.save(etudiant1);
        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNom("Bellali");
        etudiant2.setPrenom("Hafsa");
        etudiant2.setDateDeNaissance(new Date());
        etudiant2.setFilliere(filliere);
        etudiantRepository.save(etudiant2);
        Etudiant etudiant3 = new Etudiant();
        etudiant3.setNom("Assilah");
        etudiant3.setPrenom("Hajar");
        etudiant3.setDateDeNaissance(new Date());
        etudiant3.setFilliere(filliere);
        etudiantRepository.save(etudiant3);

        // Créer une note avec le module, le professeur et l'étudiant
        Note note = new Note();
        note.setNoteFinale(18.5);
        note.setModule(module);
        note.setProfesseur(professeur);
        note.setEtudiant(etudiant);
        professeur.getNoteList().add(note);
        noteRepository.save(note);
        Note note1 = new Note();
        note1.setNoteFinale(17.5);
        note1.setModule(module);
        note1.setProfesseur(professeur);
        note1.setEtudiant(etudiant2);
        professeur.getNoteList().add(note1);
        noteRepository.save(note1);
        Note note2 = new Note();
        note2.setNoteFinale(18.5);
        note2.setModule(module);
        note2.setProfesseur(professeur);
        note2.setEtudiant(etudiant3);
        professeur.getNoteList().add(note2);
        noteRepository.save(note2);
        Note note3 = new Note();
        note3.setNoteFinale(18.5);
        note3.setModule(module);
        note3.setProfesseur(professeur);
        note3.setEtudiant(etudiant1);
        professeur.getNoteList().add(note3);
        noteRepository.save(note3);


        // Ajouter l'étudiant au module et vice versa
        etudiant.getModuleList().add(module);
        etudiant1.getModuleList().add(module);
        etudiant2.getModuleList().add(module);
        etudiant3.getModuleList().add(module);
        module.getEtudiantList().add(etudiant);
        module.getEtudiantList().add(etudiant1);
        module.getEtudiantList().add(etudiant2);
        module.getEtudiantList().add(etudiant3);

        module.getNoteList().add(note);
        module.getNoteList().add(note1);
        module.getNoteList().add(note2);
        module.getNoteList().add(note3);


        etudiantRepository.save(etudiant);
        etudiantRepository.save(etudiant1);
        etudiantRepository.save(etudiant2);
        etudiantRepository.save(etudiant3);
        moduleRepository.save(module);
        professeurRepository.save(professeur);
        filliere.getList().add(etudiant);
        filliere.getList().add(etudiant1);
        filliere.getList().add(etudiant2);
        filliere.getList().add(etudiant3);
        filliere.getModuleList().add(module);
        filliere.getModuleList().add(module2);
        filliere.getModuleList().add(module3);
        filliere.getModuleList().add(module4);
        filliere.getModuleList().add(module5);
        fillièreRepository.save(filliere);
    }
}

