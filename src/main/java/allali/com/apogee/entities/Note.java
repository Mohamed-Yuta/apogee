package allali.com.apogee.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id ;
    private Double noteFinale ;
    @ManyToOne
    private Module module;
    @ManyToOne
    private Professeur professeur ;
    @ManyToOne
    private Etudiant etudiant ;
}
