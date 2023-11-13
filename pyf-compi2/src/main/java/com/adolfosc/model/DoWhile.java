package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class DoWhile implements Instruccion {
    
    @JsonProperty("condicion")
    private Instruccion condicion;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        int etIDW = res.getIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+etIDW+":");
        for(Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        this.condicion.generarCodigo(res);
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+etIDW);
    }
    
}
