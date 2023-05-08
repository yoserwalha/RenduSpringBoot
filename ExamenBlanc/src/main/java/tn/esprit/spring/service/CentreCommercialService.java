package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.repository.CentreCommercialRepository;
import tn.esprit.spring.serviceInterface.ICentreCommercialService;

import java.util.List;

@Service
@Slf4j
public class CentreCommercialService implements ICentreCommercialService {

	@Autowired
	CentreCommercialRepository centreCommercialRepository;
	@Autowired
	BoutiqueRepository boutiqueRepository;

	@Override
	public void ajoutCentre(CentreCommercial centre) {
		centreCommercialRepository.save(centre);
	}

//	@Override
//	public List<CentreCommercial> retrieveAllExamens() {
//		List<CentreCommercial> examens = (List<CentreCommercial>) examenRepository.findAll();
//		for (CentreCommercial examen : examens) {
//			log.info(" Examen : " + examen);
//		}
//		return examens;
//	}


}