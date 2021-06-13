package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Urgente implements Importe, Serializable {

    private double sobreCoste;
    private double coste;

    public Urgente(double sobreCoste, double coste){
        this.sobreCoste = sobreCoste;
        this.coste = coste;
    }

    @Override
    public double calcularImporte(){
        return coste + coste * sobreCoste * 0.01;
    }

    @Override
    public void setFacturacion(double sobreCoste) {
        this.sobreCoste = sobreCoste;
    }

    @Override
    public void setCoste(double coste) {
        this.coste = coste;
    }
}
