package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class While implements Instruccion {
    
    @JsonProperty("condicion")
    private Instruccion condicion;
    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        int etIn = res.getIdE();
        int etW = res.incIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+etIn+":");
        this.condicion.generarCodigo(res);
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+etW);
        res.getCodigo3d().agregarCodigo("goto etf"+etW);
        res.getCodigo3d().agregarCodigo("et"+etW+":");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto et"+etIn);
        res.getCodigo3d().agregarCodigo("etf"+etW+":");
    }
    
}
