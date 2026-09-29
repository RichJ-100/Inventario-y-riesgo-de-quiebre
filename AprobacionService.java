package com.empresa.inventario.aprobacion;

import org.springframework.stereotype.Service;

@Service
public class AprobacionService {
    public String aprobarRecomendacion() {
        return "Recomendación aprobada";
    }
}
