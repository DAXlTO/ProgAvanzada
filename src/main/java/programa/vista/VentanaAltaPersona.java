package programa.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAltaPersona extends JFrame{
    private VentanaAltaPersona() {
        super("");
    }
    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de alta");
        Container contenedor = ventana.getContentPane();
        JTextField nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre: ");
        JTextField correo = new JTextField(20);
        JLabel mail = new JLabel("Correo electronico: ");
        contenedor.setLayout(new FlowLayout());
        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(mail);
        contenedor.add(correo);

        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String args) {
        new VentanaAltaPersona().ejecuta();
    }
}



