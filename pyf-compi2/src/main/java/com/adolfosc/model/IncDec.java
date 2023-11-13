package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class IncDec implements Instruccion {
    
    @JsonProperty("id")
    private String id;

    @JsonProperty("opr")
    private String opr;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        res.getCodigo3d().agregarCodigo(id+" = "+id+" "+opr+" 1");
    }
    
}
