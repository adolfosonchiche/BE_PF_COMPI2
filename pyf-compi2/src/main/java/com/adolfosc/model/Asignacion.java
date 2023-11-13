package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Asignacion implements Instruccion {
    
    @JsonProperty("opr1")
    private String opr1;
    @JsonProperty("opr2")
    private Instruccion opr2;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.opr2.generarCodigo(res);
        res.getCodigo3d().agregarCodigo(opr1+" = "+res.getValor());
    }
    
}
