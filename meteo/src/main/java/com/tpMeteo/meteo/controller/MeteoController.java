package com.tpMeteo.meteo.controller;

import com.tpMeteo.meteo.model.ConditionMeteo;
import com.tpMeteo.meteo.model.Ville;
import com.tpMeteo.meteo.service.MeteoService;
import com.tpMeteo.meteo.service.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/meteo")
@AllArgsConstructor
public class MeteoController {
    private VilleService villeService;
    private MeteoService meteoService;



    @GetMapping("/test")
    public String affiche(){
        return "afficher la meteo";
    }

    @GetMapping("/ville")
    public Ville chercherVille(@RequestParam("nom") String nom){
        return villeService.chercherVille(nom);
    }

    @GetMapping
    public ConditionMeteo chercherMeteo(@RequestParam("nom") String nom){
        Ville ville = villeService.chercherVille(nom);
        return meteoService.chercherMeteo(ville.getLatitude(), ville.getLongitude());
    }

}
