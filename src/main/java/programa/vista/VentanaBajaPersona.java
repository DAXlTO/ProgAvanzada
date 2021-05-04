package programa.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBajaPersona extends JFrame {
    private VentanaBajaPersona() {
        super("");
    }
    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de baja a una persona");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

        JButton boton = new JButton("Dar de alta a una persona");
        boton = new JButton("Volver");
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String args) {
        new VentanaBajaPersona().ejecuta();
    }
}