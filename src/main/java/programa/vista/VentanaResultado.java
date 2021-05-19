package programa.vista;

import programa.controlador.Controlador;
import programa.controlador.ImplementacionControlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.ResultadoPaginaWeb;

import javax.swing.*;
import java.awt.*;

public class VentanaResultado extends JFrame {

    private VentanaResultado() {
        super("Inicio");
    }

    public static Resultado getResultado(){
        Modelo modelo = new Modelo("Pr");
        JFrame ventana = new JFrame("Opciones del Proyecto");
        ventana.addWindowListener(new EscuchadorVentana());
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(0,1,1,10));
        ventana.add(contenedor);

        Controlador con = new ImplementacionControlador();
        JButton boton = new JButton("Dar de alta a una persona");
        boton.addActionListener(new BotonAltaPersona(con, modelo,ventana)); //Registro escuchador
        contenedor.add(boton);



        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return null;
    }
    public static void main(String[] args) {
        System.out.println(        new VentanaResultado().getResultado());
    }

}
