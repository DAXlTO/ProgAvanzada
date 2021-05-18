package programa.controlador;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Modelo;
import programa.vista.Vista;

public class ImplementacionControlador implements Controlador{
    private programa.modelo.interfaces.Modelo modelo;
    private Vista vista;

    public void altaPersona(String nombre, String email, Modelo modelo) {
        this.modelo = modelo;
        Persona persona = new Persona(nombre,email);
        this.modelo.altaPersona(persona);
    }

    public String[] getPersonas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.personas();
    }

    public void eliminarPersona(int persona, Modelo modelo){
        this.modelo = modelo;
        this.modelo.eliminarPersona(persona);
    }


    public void setModelo(programa.modelo.interfaces.Modelo modelo){
        this.modelo=modelo;
    }
}
