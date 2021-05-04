package programa.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Ventana() {
        super("Inicio");
    }
    private void ejecuta() {
        JFrame ventana = new JFrame("Opciones del Proyecto");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

        JButton boton = new JButton("Dar de alta a una persona");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Dar de baja a una persona");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(new BotonBajaPersona());

        contenedor.add(boton);

        boton = new JButton("Dar de alta una tarea");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Marcar tarea como finalizada");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Añadir una persona a una tarea");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Eliminar una persona de una tarea");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Listar personas del proyecto");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Listar tareas del proyecto");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Listar las personas de una tarea");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Listar las personas que no son responsables");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Listar tareas sin personas");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Guardar y salir");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String[] args) {
        new Ventana().ejecuta();
    }
}


