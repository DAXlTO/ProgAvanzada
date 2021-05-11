package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaPersona implements ActionListener {

    private Controlador controlador;
    private Proyecto proyecto;
    JFrame ventana;

    public BotonAltaPersona(Controlador controlador, Proyecto proyecto, JFrame ventana){
        this.controlador = controlador;
        this.proyecto = proyecto;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de alta a una persona.");
        VentanaAltaPersona.main(controlador, proyecto, ventana);

    }
}

