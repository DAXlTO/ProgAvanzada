package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEliminarPersonaTarea extends JFrame implements Vista {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String auxiliar = "";

    private VentanaEliminarPersonaTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    public void ejecuta(Modelo modelo){

        JFrame ventana = new JFrame("Añadir una persona a una tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        String[] listaTareas = controlador.getTareas(modelo);
        JLabel nombreTarea = new JLabel("Nombre de la tarea: ");
        JComboBox tareas = new JComboBox(listaTareas);
        contenedor.add(tareas);
        tareas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxiliar = tareas.getSelectedItem().toString();
            }
        });

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombreTarea);
        contenedor.add(tareas);


        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Siguiente");
        boton.addActionListener(new BotonSiguienteEliminarPersona(controlador,modelo,ventana,auxiliar));
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.setSize(310,100);
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaEliminarPersonaTarea(controlador, modelo,ventana).ejecuta(modelo);
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
