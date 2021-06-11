package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Descuento implements Importe, Serializable {

    private double descuento;

    public Descuento(float coste){
        descuento = coste;
    }

    @Override
    public double calcularImporte(double coste){
        return coste - coste * descuento;
    }
}
