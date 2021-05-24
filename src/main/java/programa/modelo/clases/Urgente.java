package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Urgente implements Importe, Serializable {

    private double sobreCoste = 0.25;

    @Override
    public double calcularImporte(double coste){
        return coste + coste * sobreCoste;
    }
}
