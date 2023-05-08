package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.serviceInterface.IBoutiqueService;
import tn.esprit.spring.serviceInterface.IClientService;

import java.util.List;

@RestController
@Api(tags = "Gestion des clients")
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @PostMapping("/addEtAffecter/{idBoutique}")
    public void addEtAffecterBoutique (@RequestBody Client client, @PathVariable ("idBoutique") List<Long> idBoutiques)
    {
        clientService.ajouterEtAffecterClientBoutiques(client, idBoutiques);
    }

    @GetMapping("/listClients/{idBoutique}")
    public List<Client> ClientList(@PathVariable ("idBoutique") Long idBoutique)
    {
        return clientService.listeClients(idBoutique);
    }

    @GetMapping("/listClientsCategorie/{categorie}")
    public List<Client> ClientListCategorie(@PathVariable ("categorie") Categorie categorie)
    {
        return clientService.listeDeClientsParCategorie(categorie);
    }
}

