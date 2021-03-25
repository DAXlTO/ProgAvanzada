import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String email;
    private final List<Tarea> lista;

    public Persona(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
        lista = new ArrayList<>();
    }

    public void añadirTarea(Tarea tarea){
        lista.add(tarea);
    }


    public boolean eliminarTarea(String tarea){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).titulo.equals(tarea)){
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", lista=" + lista +
                '}';
    }

    public List<Tarea> getLista() {
        return lista;
    }
    public String getNombre(){
        return nombre;
    }

}
