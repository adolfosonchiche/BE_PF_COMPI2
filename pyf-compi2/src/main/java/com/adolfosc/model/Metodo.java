package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class Metodo implements Instruccion {
    
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    public Metodo(String nombre, LinkedList<Instruccion> instrucciones) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        res.getCodigo3d().agregarCodigo(this.nombre+" {");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("}");
    }

    public void setNombreOficial(String nombreClase){
        this.nombre = nombreClase+"_"+this.nombre;
    }
    
}
