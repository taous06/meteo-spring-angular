package com.tpMeteo.meteo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConditionMeteo {

    private String time;
    private int interval;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double apparent_temperature;
    private double precipitation;
    private double wind_speed_10m;
    private int weather_code;
}
