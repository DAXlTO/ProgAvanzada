package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;

public class VentanaAltaTarea extends JFrame{

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaAltaTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta(Modelo modelo) {
        JFrame ventana = new JFrame("Dar de alta tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        JTextField nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre de la tarea: ");


        JTextField des = new JTextField(20);
        JLabel descr = new JLabel("Descripcion: ");


        String[] personas = controlador.getPersonas(modelo);
        JLabel resp = new JLabel("Personas responsable: ");

        JComboBox per = new JComboBox(personas);

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(descr);
        contenedor.add(des);
        contenedor.add(resp);
        contenedor.add(per);


        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaAltaTarea(controlador, modelo,ventana).ejecuta(modelo);
    }

}
