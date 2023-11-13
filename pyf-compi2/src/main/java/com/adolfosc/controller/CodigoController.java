package com.adolfosc.controller;

import com.adolfosc.model.Instruccion;
import com.adolfosc.model.ResultadoInstruccion;
import io.vertx.core.cli.annotations.Description;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author hectoradolfo
 */
@Path("/parser")
public class CodigoController {

    @POST
    @Path("/c3d")
    @Description("crear codigo tres direcciones")
    public Response guardarProyectos(@Valid List<Instruccion> instrucciones) {
        System.out.println("cuartetos  recibido");
        try {
            var resultado = new ResultadoInstruccion("", 1, 1);
            for (Instruccion instruccion : instrucciones) {
                instruccion.generarCodigo(resultado);
            }
            return Response.ok(resultado).build();
        } catch (Exception e) {
            System.out.println("error " + e);
            return Response.ok("error, no se puede generar el codigo tres direcciones.").build();
        }
    }
}
