import java.util.List;

public class Persona {
    String nombre;
    String email;
    private List<Tarea> lista;

    public Persona(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public List<Tarea> getLista() {
        return lista;
    }
    public String getNombre(){
        return nombre;
    }
}
