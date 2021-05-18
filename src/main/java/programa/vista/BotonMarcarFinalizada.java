package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonMarcarFinalizada implements ActionListener {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;

    public BotonMarcarFinalizada(Controlador controlador, Modelo modelo, JFrame ventana) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de marcar una tarea como finalizada.");
        VentanaMarcarFinalizada.main(controlador, modelo, ventana);
    }
}
