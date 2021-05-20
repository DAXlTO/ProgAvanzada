package programa.modelo.clases;

public class ResultadoDocumento extends Resultado{

    String formato;
    int numPag;
    float espacio;

    public ResultadoDocumento(String identificador, int horas, String internoOcomercial,String formato, int numPag, float espacio) {
       super(identificador,horas,internoOcomercial);
       this.formato = formato;
       this.numPag = numPag;
       this.espacio = espacio;
    }
    public ResultadoDocumento(){}
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public void setEspacio(float espacio) {
        this.espacio = espacio;
    }

    public int getNumPag() {
        return numPag;
    }

    public float getEspacio() {
        return espacio;
    }
}
