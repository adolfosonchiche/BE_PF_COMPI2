package com.adolfosc.model;

import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class TipoInstruccion {
    
    public static final String ASIGNACION = "asignacion";

    public static final String SUMA = "+";
    public static final String RESTA = "-";
    public static final String MULTIPLICACION = "*";
    public static final String DIVISION = "/";
    public static final String INT = "int";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String CHAR = "char";
    public static final String ID = "id";
    public static final String BOOLEAN = "boolean";
    public static final String STRING = "String";
    public static final String PRINT = "print";
    public static final String RETURN = "return";
}
