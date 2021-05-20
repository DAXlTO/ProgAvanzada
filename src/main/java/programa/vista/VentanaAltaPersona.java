package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaPersona extends JFrame implements Vista{
    private Controlador controlador;
    private JTextField nombre;
    private JTextField email;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaAltaPersona(Controlador controlador, Modelo modelo, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de alta persona");
        Container contenedor = ventana.getContentPane();
        nombre = new JTextField(20);
        JLabel nom = new JLabel("Nombre: ");
        email = new JTextField(20);
        JLabel mail = new JLabel("Correo electronico: ");
        contenedor.setLayout(new FlowLayout());
        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(mail);
        contenedor.add(email);

        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        boton.addActionListener(actionEvent -> ventana.setVisible(false) );
        boton.addActionListener(actionEvent -> controlador.altaPersona(nombre.getText(),email.getText(), modelo));
        contenedor.add(boton);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaAltaPersona(controlador, modelo,ventana).ejecuta();
    }

    public ActionListener aceptar(JFrame ventana){

        return actionEvent ->  ventanAnterior.setVisible(true);
    }

    @Override
    public String getEntrada() {
        return nombre.getText();
    }
}



