package com.adolfosc.model;

import lombok.Data;

/**
 *
 * @author hectoradolfo
 */

@Data
public class Proyecto {
    
    private String nombre;
    private Paquete paquetePrincipal;

    public Proyecto() {
        paquetePrincipal = new Paquete();
    }
    
}
