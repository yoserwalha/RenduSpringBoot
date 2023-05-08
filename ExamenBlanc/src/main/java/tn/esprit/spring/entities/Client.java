package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nom;

    @Enumerated(EnumType.STRING)
    Genre genre;
    
    @ManyToMany(mappedBy = "clients")
    @JsonIgnore
    public Set<Boutique> boutiques;
}
