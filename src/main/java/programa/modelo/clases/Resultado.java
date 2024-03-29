package programa.modelo.clases;

public class Resultado {
    private String identificador;
    int horas;
    String internoOcomercial;

    public Resultado(String identificador, int horas, String internoOcomercial) {
        this.identificador = identificador;
        this.horas = horas;
        this.internoOcomercial = internoOcomercial;
    }
    public Resultado(){}

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "programa.Modelo.Clases.Resultado{" +
                "identificador='" + identificador + '\'' +
                ", horas=" + horas +
                ", internoOcomercial='" + internoOcomercial + '\'' +
                '}';
    }
}
