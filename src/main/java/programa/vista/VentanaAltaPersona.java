package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;
import programa.modelo.interfaces.Modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaPersona extends JFrame implements Vista{
    private Controlador controlador;
    private JTextField nombre;
    private JTextField email;
    private Modelo modelo;
    private Proyecto proyecto;
    JFrame ventanAnterior;

    private VentanaAltaPersona(Controlador controlador, Proyecto proyecto, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.proyecto = proyecto;
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
        boton.addActionListener(actionEvent -> controlador.altaPersona(nombre.getText(),email.getText(),proyecto));
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(Controlador controlador, Proyecto proyecto, JFrame ventana) {
        new VentanaAltaPersona(controlador,proyecto,ventana).ejecuta();
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);

    }

    @Override
    public String getEntrada() {
        return nombre.getText();
    }
}



