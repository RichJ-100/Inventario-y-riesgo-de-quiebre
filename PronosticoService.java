package com.empresa.inventario.pronostico;

import org.springframework.stereotype.Service;

@Service
public class PronosticoService {
    public String estimarRiesgoQuiebre() {
        return "Riesgo de quiebre estimado";
    }
}
