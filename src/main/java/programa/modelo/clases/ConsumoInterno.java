package programa.modelo.clases;

import programa.modelo.interfaces.Importe;

public class ConsumoInterno implements Importe {

    @Override
    public double calcularImporte(double coste) {
        return coste;
    }
}
