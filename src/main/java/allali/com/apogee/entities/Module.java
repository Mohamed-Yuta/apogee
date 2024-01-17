package allali.com.apogee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    @ManyToOne
    private Professeur professeur ;
    @ManyToMany
    @JoinTable(
            name = "etudiant_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    @JsonIgnore
    private List<Etudiant> etudiantList = new ArrayList<>();
    @OneToMany(mappedBy = "module" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Note> noteList = new ArrayList<>() ;
    @ManyToOne
    private Fillière filliere ;

}
