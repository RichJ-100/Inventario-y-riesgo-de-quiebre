package com.empresa.inventario.inventario;

import org.springframework.stereotype.Service;

@Service
public class InventarioService {
    public String consultarExistencias() {
        return "Existencias consultadas";
    }
}
