package allali.com.apogee.repository;

import allali.com.apogee.entities.Fillière;
import allali.com.apogee.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FillièreRepository extends JpaRepository<Fillière,Long> {

    Fillière findByNom(String nom );
}
