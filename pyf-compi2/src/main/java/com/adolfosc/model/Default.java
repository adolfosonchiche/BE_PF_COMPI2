package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Default implements Instruccion {
    
    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @JsonProperty("contieneBreak")
    private boolean contieneBreak;

    private int idES;
    private int idE;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.idE = res.getIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+idE+":");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        if(contieneBreak){
            res.getCodigo3d().agregarCodigo("goto etf"+idES);
        }
    }
    
}
