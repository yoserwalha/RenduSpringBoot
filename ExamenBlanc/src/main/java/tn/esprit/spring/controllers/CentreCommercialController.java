package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.serviceInterface.ICentreCommercialService;
@RestController
@Api(tags = "Gestion des centres commerciaux")
@RequestMapping("/CentreCommercial")
public class CentreCommercialController {

	@Autowired
	ICentreCommercialService centreCommercialService;
    //http://localhost:8087/SpringMVC/swagger-ui/index.html
//	@ApiOperation(value = "Récupérer la liste des examens")
//	@GetMapping("/retrieve-all-examens")
//	@ResponseBody
//	public List<CentreCommercial> getClients() {
//		return examenService.retrieveAllExamens();
//	}

	@PostMapping("/add")
	public void addCentre (@RequestBody CentreCommercial centre)
	{
		centreCommercialService.ajoutCentre(centre);
	}




}
