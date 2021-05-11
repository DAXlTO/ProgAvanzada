package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaAltaTarea extends JFrame{

    private Controlador controlador;
    private Proyecto proyecto;
    JFrame ventanAnterior;

    private VentanaAltaTarea(Controlador controlador, Proyecto proyecto, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.proyecto = proyecto;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta(Proyecto proyecto) {
        JFrame ventana = new JFrame("Dar de alta tarea");
        Container contenedor = ventana.getContentPane();

        JTextField nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre de la tarea: ");

        JTextField des = new JTextField(20);
        JLabel descr = new JLabel("Descripcion: ");

        String[] personas = controlador.getPersonas(proyecto);
        JComboBox per = new JComboBox(personas);

        contenedor.add(per);
        contenedor.setLayout(new FlowLayout());
        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(descr);
        contenedor.add(des);

        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(Controlador controlador, Proyecto proyecto, JFrame ventana) {
        new VentanaAltaTarea(controlador,proyecto,ventana).ejecuta(proyecto);
    }

}
