package programa.controlador;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Proyecto;
import programa.modelo.interfaces.Modelo;

public class ImplementacionControlador implements Controlador{
    private Modelo modelo;
    //private Vista vista;

    public void altaPersona(String nombre, String email, Proyecto proyecto) {
        modelo = new Proyecto("pr");
        //String entrada = vista.getEntrada();
        Persona persona = new Persona(nombre,email);
        modelo.altaPersona(persona);
    }

    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
}
