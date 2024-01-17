package allali.com.apogee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Affichage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @OneToOne(mappedBy = "affichage")
    private Etudiant etudiant;
    private double semestre;
    private String commentaire ;

}
