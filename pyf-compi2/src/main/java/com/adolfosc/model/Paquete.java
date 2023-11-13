package com.adolfosc.model;

import java.util.LinkedList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */

@Data
public class Paquete {
    
    private String nombre;
    private String id;
    private List<Archivo> archivos;
    private List<Paquete> paquetes;

    public Paquete() {
        archivos = new LinkedList<>();
        paquetes = new LinkedList<>();
    }
    
    public void agregarPaquete(Paquete paquete){
        this.paquetes.add(paquete);
    }

    public void agregarArchivo(Archivo archivo){
        this.archivos.add(archivo);
    }
    
}
