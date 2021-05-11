package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaBajaPersona extends JFrame implements Vista{
    private Controlador controlador;
    private int numeros;
    private Proyecto proyecto;
    JFrame ventanAnterior;

    private VentanaBajaPersona(Controlador controlador, Proyecto proyecto, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.proyecto = proyecto;
        this.ventanAnterior = ventanAnterior;
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de baja a una persona");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

        String[] personas = controlador.getPersonas(proyecto);
        JComboBox per = new JComboBox(personas);
        contenedor.add(per);


        controlador.eliminarPersona(numeros, proyecto);

        JButton boton = new JButton("Dar de alta a una persona");
        boton = new JButton("Volver");
        boton.addActionListener(aceptar(ventana));
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        boton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Proyecto proyecto, JFrame ventana) {
        new VentanaBajaPersona(controlador, proyecto, ventana).ejecuta();
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);
    }

    @Override
    public String getEntrada() {
        return null;
    }
}