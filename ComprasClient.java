package com.empresa.inventario.integracion.compras;

import org.springframework.stereotype.Component;

@Component
public class ComprasClient {
    public String enviarOrdenCompra() {
        return "Orden de compra enviada al sistema externo";
    }
}
