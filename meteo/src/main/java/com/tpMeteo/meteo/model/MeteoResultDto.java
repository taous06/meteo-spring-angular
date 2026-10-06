package com.tpMeteo.meteo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeteoResultDto {
    private ConditionMeteo current;
}
