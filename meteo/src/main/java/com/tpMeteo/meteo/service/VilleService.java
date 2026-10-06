package com.tpMeteo.meteo.service;

import com.tpMeteo.meteo.model.ResultDto;
import com.tpMeteo.meteo.model.Ville;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class VilleService {

    private RestClient restClient = RestClient.create();

    public Ville chercherVille(String nomVille) {
        ResultDto result = restClient.get().uri("https://geocoding-api.open-meteo.com/v1/search"
                                + "?name={ville}&count=1&language=fr&format=json",
                                nomVille)
                .retrieve()
                .body(ResultDto.class);
        if (result == null
                || result.getResults() == null
                || result.getResults().isEmpty()) {
            throw new IllegalArgumentException("La ville est introuvable");
        }

        return result.getResults().get(0);


    }
}
