package programa.Clases;

import programa.Interfaces.Importe;

public class ConsumoInterno implements Importe {

    @Override
    public double calcularImporte(double coste) {
        return coste;
    }
}
