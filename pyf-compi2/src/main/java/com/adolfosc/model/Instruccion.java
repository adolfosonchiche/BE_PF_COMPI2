package com.adolfosc.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "tipo", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Operacion.class, name = "Operacion"),
        @JsonSubTypes.Type(value = Asignacion.class, name = "Asignacion"),
        @JsonSubTypes.Type(value = Asignacion.class, name = "Declaracion"),
        @JsonSubTypes.Type(value = Metodo.class, name = "Metodo"),
        @JsonSubTypes.Type(value = Clase.class, name = "Clase"),
        @JsonSubTypes.Type(value = If.class, name = "If"),
        @JsonSubTypes.Type(value = ElseIf.class, name = "ElseIf"),
        @JsonSubTypes.Type(value = Else.class, name = "Else"),
        @JsonSubTypes.Type(value = While.class, name = "While"),
        @JsonSubTypes.Type(value = DoWhile.class, name = "DoWhile"),
        @JsonSubTypes.Type(value = For.class, name = "For"),
        @JsonSubTypes.Type(value = IncDec.class, name = "IncDec"),
        @JsonSubTypes.Type(value = Switch.class, name = "Switch"),
        @JsonSubTypes.Type(value = Case.class, name = "Case"),
        @JsonSubTypes.Type(value = Default.class, name = "Default"),
        @JsonSubTypes.Type(value = Break.class, name = "Break"),
})

public interface Instruccion {
    
    public void generarCodigo(ResultadoInstruccion res);
}
