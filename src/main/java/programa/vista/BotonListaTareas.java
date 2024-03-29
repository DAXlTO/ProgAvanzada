package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonListaTareas implements ActionListener {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;

    public BotonListaTareas(Controlador controlador, Modelo modelo, JFrame ventana){
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de listar las tarras.");
        VentanaListaTareas.main(controlador, modelo, ventana);
    }
}
