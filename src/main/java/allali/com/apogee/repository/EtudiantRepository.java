package allali.com.apogee.repository;

import allali.com.apogee.entities.Etudiant;
import allali.com.apogee.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContainsOrPrenomContains(String kwN, String kwP, Pageable pageable);
    Etudiant findByNom(String nom);

}
