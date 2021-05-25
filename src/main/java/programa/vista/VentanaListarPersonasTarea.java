package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;

public class VentanaListarPersonasTarea extends JFrame {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String tarea;

    private VentanaListarPersonasTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaListarPersonasTarea(controlador, modelo,ventana).ejecuta();
    }

    public void ejecuta() {
        JFrame ventana = new JFrame("Listado de tareas");
        JPanel contenedor  = new JPanel();
        ventana.add(contenedor);

        String[] listaTareas = controlador.getTareas(modelo);
        JLabel nombreTarea = new JLabel("Nombre de la tarea: ");
        JComboBox tareas = new JComboBox(listaTareas);

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombreTarea);
        contenedor.add(tareas);

        JButton boton = new JButton("Volver");
        boton.addActionListener(new BotonVolver(controlador,modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> ventanAnterior.setVisible(true));
        boton.addActionListener(actionEvent -> ventana.setVisible(false));

        boton.addActionListener(actionEvent -> VentanaSiguienteListarPersonasTarea.main(controlador,modelo,ventana,listaTareas[tareas.getSelectedIndex()]));
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
    }

}
