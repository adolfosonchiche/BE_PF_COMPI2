package com.adolfosc.controller;

import com.adolfosc.model.Proyecto;
import com.adolfosc.util.archivo.ArchivoUtil;
import com.adolfosc.util.archivo.ConstructorXML;
import com.adolfosc.util.archivo.ManejadorLista;
import com.adolfosc.util.archivo.RecuperadorArchivo;
import io.vertx.core.cli.annotations.Description;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author hectoradolfo
 */

@Path("/archivo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArchivoController {

    public static final String PATH_DATA_PROYECTO = "data/";
    @Inject private ConstructorXML constructorXML;
    @Inject private ManejadorLista manejadorLista;
    @Inject private RecuperadorArchivo recuperadorProyecto;
    
    @GET
    @Path("/proyecto/{nombre}")
    @Description("obtener un proyecto por nombre")
    public Response recuperarProyecto(@PathParam("nombre") String nombre) {
        var proy = recuperadorProyecto.recuperar(nombre);   
        return Response.ok(proy).build();
    }
    
    @GET
    @Path("/proyectos")
    @Description("obtener toda la lista de proyectos creados")
    public Response obtenerListaProyectos() {
        var proy =  manejadorLista.recuperarListaProyectos();   
        return Response.ok(proy).build();
    }
    
    @POST
    @Path("/create")
    @Description("crear un proyecto nuevo o actualizar")
    public Response guardarProyectos(@Valid Proyecto proyecto) {
        System.out.println("proyecto "+proyecto.getNombre()+" recibido");
        try {
            ArchivoUtil.escribirArchivo(new File(PATH_DATA_PROYECTO+proyecto.getNombre()+".xml"),constructorXML.construirXML(proyecto));
            manejadorLista.registrarProyecto(proyecto.getNombre());
            return Response.ok("El proyecto "+proyecto.getNombre()+" ha sido guardado.").build();
        }catch (IOException e){
            System.out.println("error " + e);
            if(proyecto==null | proyecto.getNombre()==null){
                return Response.ok("No hay proyecto en curso para guardar.").build();
            }else {
                return Response.ok("Error al intentar guardar el proyecto " + proyecto.getNombre() + " .").build();
            }
        } 
    }

}
