package com.tpMeteo.meteo.service;

import com.tpMeteo.meteo.model.ConditionMeteo;
import com.tpMeteo.meteo.model.MeteoResultDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MeteoService {

    private RestClient restClient = RestClient.create();

    public ConditionMeteo chercherMeteo(double latitude, double longitude){
        MeteoResultDto result = restClient.get()
                .uri(
                        "https://api.open-meteo.com/v1/forecast"
                                + "?latitude={latitude}&longitude={longitude}"
                                + "&current=temperature_2m,relative_humidity_2m,"
                                + "apparent_temperature,precipitation,"
                                + "wind_speed_10m,weather_code"
                                + "&timezone=auto",
                        latitude,
                        longitude
                )
                .retrieve()
                .body(MeteoResultDto.class);

        if (result == null || result.getCurrent() == null) {
            throw new IllegalStateException(
                    "Les données météo sont indisponibles"
            );
        }

        return result.getCurrent();
    }

}
