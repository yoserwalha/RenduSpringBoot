package tn.esprit.spring.serviceInterface;

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;

import java.util.List;

public interface IClientService {
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    List<Client> listeClients(Long idBoutique);
    List<Client> listeDeClientsParCategorie(Categorie categorie);
    void nbreClientParGenre();
}
