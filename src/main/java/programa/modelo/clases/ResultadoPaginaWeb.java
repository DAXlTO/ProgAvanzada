package programa.modelo.clases;

public class ResultadoPaginaWeb extends Resultado{

    String estaticaOdinamica;
    String lenguaje;
    String backend;

    public ResultadoPaginaWeb(String identificador, int horas, String internoOcomercial, String estaticaOdinamica, String lenguaje, String backend) {
        super(identificador,horas,internoOcomercial);
        this.estaticaOdinamica = estaticaOdinamica;
        this.lenguaje = lenguaje;
        this.backend = backend;
    }

    public ResultadoPaginaWeb(){}

    public String getEstaticaOdinamica() {
        return estaticaOdinamica;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setEstaticaOdinamica(String estaticaOdinamica) {
        this.estaticaOdinamica = estaticaOdinamica;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getBackend() {
        return backend;
    }
}
