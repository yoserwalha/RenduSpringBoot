package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    @Enumerated(EnumType.STRING)
    Categorie categorie;

    @ManyToOne
    CentreCommercial centre;

    @ManyToMany
    Set<Client> clients;
}
