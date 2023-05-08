package tn.esprit.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.repository.CentreCommercialRepository;
import tn.esprit.spring.serviceInterface.IBoutiqueService;

import java.util.List;

@Service
@Slf4j
public class BoutiqueService implements IBoutiqueService {
    @Autowired
    BoutiqueRepository boutiqueRepository;

    @Autowired
    CentreCommercialRepository centreCommercialRepository;

    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommercial c = centreCommercialRepository.getById(idCentre);
        for (Boutique b : lb) {
            b.setCentre(c);
            boutiqueRepository.save(b);
        }

    }
    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        return boutiqueRepository.listeBoutiques(idCentre);
    }

}
