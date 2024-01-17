package allali.com.apogee.repository;

import allali.com.apogee.entities.Module;
import allali.com.apogee.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    Module findByNom(String nom);

}
