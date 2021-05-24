package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Descuento implements Importe, Serializable {

    private double descuento = 0.1;
    @Override
    public double calcularImporte(double coste){
        return coste - coste * descuento;
    }
}
