package com.adolfosc.model;

import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class ResultadoInstruccion {
    
    private String valor;
    private int idT;
    private int idE;
    private Codigo3d codigo3d;

    public ResultadoInstruccion(String valor, int idT, int idE) {
        this.valor = valor;
        this.idT = idT;
        this.idE = idE;
        codigo3d = new Codigo3d();
    }
    
    public int incIdT() {
        this.idT++;
        return this.idT;
    }

    public int incIdE() {
        this.idE++;
        return this.idE;
    }
    
}
