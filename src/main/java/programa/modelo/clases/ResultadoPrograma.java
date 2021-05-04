package programa.modelo.clases;

public class ResultadoPrograma extends Resultado{

    String lenguaje;
    int numero_lineas;
    int numero_modulos;

    public ResultadoPrograma(String identificador, Integer horas, String internoOcomercial,String lenguaje,int numero_lineas, int numero_modulos) {
        super(identificador,horas,internoOcomercial);
        this.lenguaje = lenguaje;
        this.numero_lineas = numero_lineas;
        this.numero_modulos = numero_modulos;
    }
}
