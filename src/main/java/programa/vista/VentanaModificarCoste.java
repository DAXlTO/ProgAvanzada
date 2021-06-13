package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaModificarCoste extends JFrame{
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    JFrame ventana;

    private VentanaModificarCoste(Controlador controlador, Modelo modelo, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior = ventanAnterior;
    }

    private void ejecuta() {
        ventana = new JFrame("Dar de alta persona");
        Container contenedor = ventana.getContentPane();


        String[] listaTareas = controlador.getTareas(modelo);
        JLabel nombre = new JLabel("Elige la tarea: ");
        JComboBox tareas = new JComboBox(listaTareas);



        JLabel cost = new JLabel("Introduce el nuevo coste de la tarea: ");
        JTextField coste = new JTextField();
        JLabel var = new JLabel("Introduce la variación del producto: ");
        JTextField variacion = new JTextField();


        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombre);
        contenedor.add(tareas);
        contenedor.add(cost);
        contenedor.add(coste);
        contenedor.add(var);
        contenedor.add(variacion);


        JButton boton = new JButton("Volver");
        boton.addActionListener(new BotonVolver(controlador,modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> ventana.setVisible(false));
        boton.addActionListener(actionEvent -> ventanAnterior.setVisible(true));
        boton.addActionListener(actionEvent -> controlador.altaPersona(nombre.getText(),email.getText(), modelo));
        contenedor.add(boton);

        ventana.setSize(250,175);
        //ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaModificarCoste(controlador, modelo,ventana).ejecuta();
    }


    public ActionListener volver(JFrame ventanAnterior){
        ventanAnterior.setVisible(true);
        return actionEvent ->  ventana.setVisible(false);
    }


}



