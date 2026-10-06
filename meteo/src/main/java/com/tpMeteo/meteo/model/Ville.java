package com.tpMeteo.meteo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ville {
    private String name;
    private double latitude;
    private double longitude;
    private String country;
}
