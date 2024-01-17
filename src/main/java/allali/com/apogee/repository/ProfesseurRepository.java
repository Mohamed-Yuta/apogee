package allali.com.apogee.repository;

import allali.com.apogee.entities.Etudiant;
import allali.com.apogee.entities.Note;
import allali.com.apogee.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {

    Professeur findByNom(String nom);
}
