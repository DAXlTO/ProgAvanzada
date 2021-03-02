public class Resultado {
    private String identificador;
    int horas;
    String internoOcomercial;

    public Resultado(String identificador, int horas, String internoOcomercial) {
        this.identificador = identificador;
        this.horas = horas;
        this.internoOcomercial = internoOcomercial;
    }

    public String getIdentificador() {
        return identificador;
    }
}
