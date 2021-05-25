package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaTarea implements ActionListener {

    private Modelo modelo;
    private Controlador controlador;
    JFrame ventana;

    public BotonAltaTarea(Modelo modelo, Controlador controlador, JFrame ventana){
        this.modelo = modelo;
        this.controlador = controlador;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de añadir una tarea.");
        ventana.setVisible(false);
        VentanaAltaTarea.main(controlador, modelo,ventana);
    }
}
