package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Declaracion implements Instruccion {
    
    @JsonProperty("opr1")
    private String opr1;
    @JsonProperty("opr2")
    private Instruccion opr2;
    @JsonProperty("opr")
    private String opr;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.opr2.generarCodigo(res);
        System.out.println("or ....>" + opr);
         System.out.println("valor " + res.getValor());
         if(this.opr1.equals("")) {
             res.getCodigo3d().agregarCodigo(res.getValor());
         } else {
             res.getCodigo3d().agregarCodigo(opr1+" = "+res.getValor());
         }
        
    }
    
}
