package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class ConsumoInterno implements Importe, Serializable {

    private double coste;

    public ConsumoInterno(double coste){
        this.coste=coste;
    }

    @Override
    public double calcularImporte() {
        return coste;
    }

    @Override
    public void setFacturacion(double sobreCoste) {
        return;
    }

    @Override
    public void setCoste(double coste) {
        this.coste = coste;
    }
}
