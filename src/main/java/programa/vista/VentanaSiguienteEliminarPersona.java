package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaSiguienteEliminarPersona extends JFrame {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String tarea;

    private VentanaSiguienteEliminarPersona(Controlador controlador, Modelo modelo, JFrame ventanAnterior, String tarea) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
        this.tarea = tarea;
        ventanAnterior.setVisible(false);
    }

    public void ejecuta(){

        JFrame ventana = new JFrame("Eliminar persona de la tarea " + tarea);
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        String[] personas = controlador.getPersonasTarea(tarea, modelo);
        JLabel nombreTarea = new JLabel("Nombre de la persona: ");
        JComboBox perso = new JComboBox(personas);

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombreTarea);
        contenedor.add(perso);


        JButton boton = new JButton("Volver");
        boton.addActionListener(actionEvent -> ventanAnterior.setVisible(true));
        boton.addActionListener(actionEvent -> ventana.setVisible(false));

        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> controlador.darBajaPersonaTarea(personas[perso.getSelectedIndex()],tarea,modelo));
        boton.addActionListener(actionEvent -> ventana.setVisible(false));
        boton.addActionListener(new BotonVolver(controlador,modelo,ventana));

        contenedor.add(boton);

        ventana.setSize(290,100);
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana, String tarea) {
        new VentanaSiguienteEliminarPersona(controlador, modelo,ventana,tarea).ejecuta();
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);
    }


}
