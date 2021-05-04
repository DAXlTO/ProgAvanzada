package programa.Modelo.Clases;

import programa.Modelo.Interfaces.Importe;

public class ConsumoInterno implements Importe {

    @Override
    public double calcularImporte(double coste) {
        return coste;
    }
}
