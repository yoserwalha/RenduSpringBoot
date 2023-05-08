package tn.esprit.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.repository.CentreCommercialRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.serviceInterface.IClientService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ClientService implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BoutiqueRepository boutiqueRepository;

    @Override
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
        for (Long b : idBoutiques){
            Boutique bb = boutiqueRepository.findById(b).orElse(null);
            bb.getClients().add(client);
        }
        clientRepository.save(client);
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
        return clientRepository.listeClients(idBoutique);
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        return clientRepository.listeClientsCategorie(categorie);
    }

    @Override
    @Scheduled(fixedRate = 30000)
    public void nbreClientParGenre() {
        System.out.println("Feminin = "+clientRepository.NombreClientParGenre().get(0));
        System.out.println("Masculin = "+clientRepository.NombreClientParGenre().get(1));
    }
}
