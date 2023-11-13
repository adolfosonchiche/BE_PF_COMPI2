package com.adolfosc.model;

import java.util.LinkedList;
import lombok.Data;

/**
 *
 * @author hectoradolfo
 */
@Data
public class InstruccionOld {
    
    private InstruccionOld opr1;
    private InstruccionOld opr2;
    private Object resultado;
    private String opr;
    private LinkedList<InstruccionOld> instrucciones;
    
}
