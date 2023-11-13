package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Else implements Instruccion {
    
    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    private int idEF;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+this.idEF);
    }
    
}
