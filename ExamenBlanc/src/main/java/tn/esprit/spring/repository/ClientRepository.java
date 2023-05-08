package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select c from Client c join c.boutiques b where b.id=:idB")
    List<Client> listeClients(@Param("idB") Long idBoutique);
    @Query("select c from Client c join c.boutiques b where b.categorie=:categorie")
    List<Client> listeClientsCategorie(@Param("categorie") Categorie categorie);

    @Query("SELECT COUNT(c) FROM Client c GROUP BY c.genre")
    List<Integer> NombreClientParGenre();

}
