package com.adolfosc.model;

import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Codigo3d {
    
    private String codigo;

    public Codigo3d() {
        this.codigo = "";
    }

    public void agregarCodigo(String codigo){
        this.codigo += codigo+"\n";
    }
    
}
