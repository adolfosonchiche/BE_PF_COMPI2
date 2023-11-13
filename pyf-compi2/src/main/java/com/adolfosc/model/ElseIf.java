package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class ElseIf implements Instruccion {
    
    @JsonProperty("condicion")
    private Instruccion condicion;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    private int idEF;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.condicion.generarCodigo(res);
        int numEtIf = res.getIdE();
        int numEtN = res.incIdE();
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+numEtIf);
        res.getCodigo3d().agregarCodigo("goto et"+numEtN);
        res.getCodigo3d().agregarCodigo("et"+numEtIf+":");
        res.incIdE();
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+this.idEF);
        res.getCodigo3d().agregarCodigo("et"+numEtN+":");
    }
    
}
