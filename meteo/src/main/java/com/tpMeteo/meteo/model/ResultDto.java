package com.tpMeteo.meteo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResultDto {
    private List<Ville> results;
}
