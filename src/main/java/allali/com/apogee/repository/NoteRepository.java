package allali.com.apogee.repository;

import allali.com.apogee.entities.Module;
import allali.com.apogee.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByModuleId(Long moduleId);
    List<Note> findByProfesseurId(Long professeurId);
    List<Note> findByEtudiantId(Long etudiantId);

}
