package programa.controlador;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Proyecto;
import programa.modelo.interfaces.Modelo;

import java.util.List;

public class ImplementacionControlador implements Controlador{
    private Modelo modelo;
    //private Vista vista;

    public void altaPersona(String nombre, String email, Proyecto proyecto) {
        modelo = proyecto;
        //String entrada = vista.getEntrada();
        Persona persona = new Persona(nombre,email);
        modelo.altaPersona(persona);
    }

    public String[] getPersonas(Proyecto proyecto){
        modelo = proyecto;
        return modelo.personas();
    }

    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
}
