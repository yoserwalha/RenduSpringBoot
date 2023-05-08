package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client;

import java.util.List;


@Repository
public interface CentreCommercialRepository extends JpaRepository<CentreCommercial, Long> {
    @Query("select c from Client c join c.boutiques b where b.id=:idB")
    List<Client> listeClients(@Param("idB") Long idBoutique);


}
