package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaAñadirPersonaTarea extends JFrame implements Vista {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaAñadirPersonaTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
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

        List<Persona> listaPersonas = controlador.getPersonas(modelo);
        String[] persona = new String[listaPersonas.size()];
        for (int i = 0; i < listaPersonas.size();i++){
            persona[i] = listaPersonas.get(i).getNombre();
        }
        JLabel nombrePersona = new JLabel("Nombre de la persona: ");

        JComboBox per = new JComboBox(persona);
        contenedor.add(per);

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombreTarea);
        contenedor.add(tareas);
        contenedor.add(nombrePersona);
        contenedor.add(per);

        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> controlador.añadirPersonaATarea(listaTareas[tareas.getSelectedIndex()],listaPersonas.get(per.getSelectedIndex()).getNombre(), modelo));
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.setSize(310,140);
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaAñadirPersonaTarea(controlador, modelo,ventana).ejecuta(modelo);
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
