import java.util.List;

public class Persona {
    String nombre;
    String email;
    List<Tarea> lista;

    public Persona(String nombre, String email, List<Tarea> lista){
        this.nombre = nombre;
        this.email = email;
        this.lista = lista;
    }
}
