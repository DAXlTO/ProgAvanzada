package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaPersona extends JFrame{
    private Controlador controlador;
    private JTextField nombre;
    private JTextField email;
    private Modelo modelo;
    JFrame ventanAnterior;
    JFrame ventana;

    private VentanaAltaPersona(Controlador controlador, Modelo modelo, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior = ventanAnterior;
    }

    private void ejecuta() {
        ventana = new JFrame("Dar de alta persona");
        Container contenedor = ventana.getContentPane();
        nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre: ");
        email = new JTextField(20);
        JLabel mail = new JLabel("Correo electrónico: ");
        contenedor.setLayout(new FlowLayout());

        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(mail);
        contenedor.add(email);

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
        new VentanaAltaPersona(controlador, modelo,ventana).ejecuta();
    }


    public ActionListener volver(JFrame ventanAnterior){
        ventanAnterior.setVisible(true);
        return actionEvent ->  ventana.setVisible(false);
    }


}



