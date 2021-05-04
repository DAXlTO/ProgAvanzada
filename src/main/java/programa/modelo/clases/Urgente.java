package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

public class Urgente implements Importe {

    private double sobreCoste = 0.25;

    @Override
    public double calcularImporte(double coste){
        return coste + coste * sobreCoste;
    }
}
