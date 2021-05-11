package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaTarea implements ActionListener {

    private Proyecto proyecto;
    private Controlador controlador;
    JFrame ventana;

    public BotonAltaTarea(Proyecto proyecto, Controlador controlador, JFrame ventana){
        this.proyecto = proyecto;
        this.controlador = controlador;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de añadir una tarea.");
        VentanaAltaTarea.main(controlador,proyecto,ventana);
    }
}
