package programa.Clases;

public abstract class Factura {
    float coste;
    float facturacion;

    public Factura(float coste, float facturacion){
        this.coste = coste;
        this.facturacion = facturacion;
    }
}
