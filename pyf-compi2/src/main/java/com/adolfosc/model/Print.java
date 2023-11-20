package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Print implements Instruccion {
    
    @JsonProperty("opr1")
    private String opr1;
    @JsonProperty("opr2")
    private Instruccion opr2;
    @JsonProperty("opr")
    private String opr;
    
    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.opr2.generarCodigo(res);
        System.out.println("opr --> " + opr);
       
        //this.opr2.
        res.getCodigo3d().agregarCodigo("print("+res.getValor() + ")");
    }
    
}
