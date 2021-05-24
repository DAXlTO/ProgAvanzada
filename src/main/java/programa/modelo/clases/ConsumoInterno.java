package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

import java.io.Serializable;

public class ConsumoInterno implements Importe, Serializable {

    @Override
    public double calcularImporte(double coste) {
        return coste;
    }
}
