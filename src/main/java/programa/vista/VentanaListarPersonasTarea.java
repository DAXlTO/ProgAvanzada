package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaListarPersonasTarea extends JFrame implements Vista {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

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
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(new BotonSiguienteListarPersonasTarea(controlador,modelo,ventana,listaTareas[tareas.getSelectedIndex()]));
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);

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
