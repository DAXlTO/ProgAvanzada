package programa.vista;

import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.*;

public class VentanaAltaTarea extends JFrame{
    private VentanaAltaTarea() {
        super("");
    }
    private void ejecuta(Proyecto proyecto) {
        JFrame ventana = new JFrame("Dar de alta tarea");
        Container contenedor = ventana.getContentPane();

        JTextField nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre de la tarea: ");

        JTextField correo = new JTextField(20);
        JLabel mail = new JLabel("Descripcion: ");
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
    public static void main(Proyecto proyecto) {
        new VentanaAltaTarea().ejecuta(proyecto);
    }

}
