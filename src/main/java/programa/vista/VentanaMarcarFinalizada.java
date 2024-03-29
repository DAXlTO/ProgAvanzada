package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaMarcarFinalizada extends JFrame {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    Resultado resultado;


    private VentanaMarcarFinalizada(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    public void setResultado(Resultado resultado){
        this.resultado = resultado;
    }

    public void ejecuta(Modelo modelo){
        JFrame ventana = new JFrame("Marcar una tarea como finalizada");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        List<String> listaTareas = controlador.getTareasNoFinalizadas(modelo);
        String[] noFinalizadas = new String[listaTareas.size()];
        for (int i = 0; i < listaTareas.size();i++){
            noFinalizadas[i] = listaTareas.get(i);
        }
        JLabel nombre = new JLabel("Nombre de la tarea: ");
        JComboBox tareas = new JComboBox(noFinalizadas);
        contenedor.add(tareas);

        contenedor.add(nombre);
        contenedor.add(tareas);
        contenedor.setLayout(new FlowLayout());
        JButton boton = new JButton("Volver");
        boton.addActionListener(new BotonVolver(controlador,modelo,ventana));

        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> VentanaSiguienteFinalizarTarea.main(controlador,modelo,ventana,noFinalizadas[tareas.getSelectedIndex()]));
        boton.addActionListener(actionEvent -> ventana.setVisible(false));

        contenedor.add(boton);

        ventana.setSize(290,100);
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaMarcarFinalizada(controlador, modelo,ventana).ejecuta(modelo);
    }


}
