package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonSiguienteEliminarPersona implements ActionListener {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;
    String tarea;

    public BotonSiguienteEliminarPersona(Controlador controlador, Modelo modelo, JFrame ventana, String tarea){
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventana=ventana;
        this.tarea = tarea;
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        System.out.println("Has pulsado el boton de añadir una persona a una tarea");
        VentanaSiguienteEliminarPersona.main(controlador,modelo,ventana,tarea);
    }
}
