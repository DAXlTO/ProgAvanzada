package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class Descuento implements Importe, Serializable {

    private double descuento;
    private double coste;

    public Descuento(double descuento, double coste){
        this.descuento = descuento;
        this.coste = coste;
    }

    @Override
    public double calcularImporte(){
        return coste - coste * descuento * 0.01;
    }

    @Override
    public void setFacturacion(double descuento) {
        this.descuento = descuento;
    }


}
