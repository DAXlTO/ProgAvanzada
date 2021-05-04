package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

public class Descuento implements Importe {

    private double descuento = 0.1;
    @Override
    public double calcularImporte(double coste){
        return coste - coste * descuento;
    }
}
