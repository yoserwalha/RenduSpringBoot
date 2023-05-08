package tn.esprit.spring.serviceInterface;

import tn.esprit.spring.entities.Boutique;

import java.util.List;

public interface IBoutiqueService {
    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
    List<Boutique> listeBoutiques(Long idCentre);

}
