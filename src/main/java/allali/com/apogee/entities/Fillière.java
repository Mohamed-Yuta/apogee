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
public class Fillière {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;


    @OneToMany(mappedBy = "filliere" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Etudiant> list = new ArrayList<>()  ;
    @OneToMany(mappedBy = "filliere" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Module> moduleList = new ArrayList<>() ;



}
