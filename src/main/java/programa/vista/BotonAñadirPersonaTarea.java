package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAñadirPersonaTarea implements ActionListener {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;

    public BotonAñadirPersonaTarea(Controlador controlador, Modelo modelo, JFrame ventana){
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventana=ventana;
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        System.out.println("Has pulsado el boton de añadir una persona a una tarea");
        VentanaAñadirPersonaTarea.main(controlador,modelo,ventana);
    }
}
