package programa;

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
}
