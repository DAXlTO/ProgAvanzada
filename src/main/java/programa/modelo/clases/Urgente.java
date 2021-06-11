package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Urgente implements Importe, Serializable {

    private double sobreCoste;
    public Urgente(float coste){
        sobreCoste = coste;
    }

    @Override
    public double calcularImporte(double coste){
        return coste + coste * sobreCoste;
    }
}
