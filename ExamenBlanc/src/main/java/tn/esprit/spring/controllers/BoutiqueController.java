package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.serviceInterface.IBoutiqueService;
import tn.esprit.spring.serviceInterface.ICentreCommercialService;

import java.util.List;

@RestController
@Api(tags = "Gestion des boutiques")
@RequestMapping("/Boutique")
public class BoutiqueController {
    @Autowired
    IBoutiqueService boutiqueService;

    @PostMapping("/addEtAffecter/{idCentre}")
    public void addEtAffecterBoutique (@RequestBody List<Boutique> boutiques, @PathVariable Long idCentre)
    {
        boutiqueService.ajouterEtAffecterlisteBoutiques(boutiques, idCentre);
    }
    @GetMapping("/listBoutiques/{idCentre}")
    public List<Boutique> BoutiqueList(@PathVariable ("idCentre") Long idCentre)
    {
        return boutiqueService.listeBoutiques(idCentre);
    }
}
