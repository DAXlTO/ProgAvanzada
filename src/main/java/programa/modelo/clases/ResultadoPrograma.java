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
    public ResultadoPrograma(){}

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setNumero_lineas(int numero_lineas) {
        this.numero_lineas = numero_lineas;
    }

    public void setNumero_modulos(int numero_modulos) {
        this.numero_modulos = numero_modulos;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public int getNumero_lineas() {
        return numero_lineas;
    }

    public int getNumero_modulos() {
        return numero_modulos;
    }
}
