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





    
}
