package com.adolfosc.util.archivo;

import com.adolfosc.controller.ArchivoController;
import com.adolfosc.model.Proyecto;
import com.adolfosc.util.archivo.analisis.Lexer;
import com.adolfosc.util.archivo.analisis.Parser;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.StringReader;

/**
 *
 * @author hectoradolfo
 */
@ApplicationScoped
public class RecuperadorArchivo {

    public Proyecto recuperar(String proyecto){
        File file = new File(ArchivoController.PATH_DATA_PROYECTO+proyecto+".xml");
        if(file.exists()){
            Lexer lexer = new Lexer(new StringReader(ArchivoUtil.recuperarArchivo(file)));
            Parser parser = new Parser(lexer);
            try {
                parser.parse();
                System.out.println("ANALISIS CON 0 ERRORES");
                return parser.getProyecto();
            }catch (Exception e){
                e.printStackTrace();
                return new Proyecto();
            }
        }else{
            return new Proyecto();
        }
    }
    
}
