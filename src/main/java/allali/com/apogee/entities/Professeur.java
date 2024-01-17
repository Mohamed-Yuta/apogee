package allali.com.apogee.entities;

import allali.com.apogee.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom , prenom ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance ;
    private String tel ;
    private String adresse ;
    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Module> modulelist = new ArrayList<>();
    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY)
    @JsonIgnore
    private  List<Note> noteList = new ArrayList<>();
}
