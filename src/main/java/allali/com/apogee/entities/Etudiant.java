package allali.com.apogee.entities;

import allali.com.apogee.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private Date dateDeNaissance ;
    @OneToOne()
    private Affichage affichage ;
    @ManyToOne
    @JsonIgnore
    private Fillière filliere ;
    @ManyToMany(mappedBy = "etudiantList")
    @JsonIgnore
    private List<Module> moduleList = new ArrayList<>() ;
    @OneToMany(mappedBy = "etudiant" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();
    public Double calculerMoyenneSemestre() {
        if (notes.isEmpty()) {
            return null; // Handle the case where there are no modules to avoid division by zero
        }

        double sommeNotes = 0.0;
        int nombreModules = notes.size();

        for (Note note : notes) {

                if (note.getEtudiant().equals(this)) {
                    sommeNotes += note.getNoteFinale();
                }

        }

        return sommeNotes / nombreModules;
    }
}


