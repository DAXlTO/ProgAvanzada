package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaBajaPersona extends JFrame implements Vista{
    private Controlador controlador;
    private int numeros;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaBajaPersona(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior = ventanAnterior;
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de baja a una persona");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

        List<Persona> personas = controlador.getPersonas(modelo);
        String[] persona = new String[personas.size()];
        for (int i = 0; i < personas.size();i++){
            persona[i]=personas.get(i).getNombre();
        }
        JComboBox per = new JComboBox(persona);
        contenedor.add(per);


        JButton boton = new JButton("Dar de alta a una persona");
        boton = new JButton("Volver");
        boton.addActionListener(aceptar(ventana));
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        boton.addActionListener(actionEvent -> controlador.eliminarPersona(per.getSelectedIndex(), modelo));
        boton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaBajaPersona(controlador, modelo, ventana).ejecuta();
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