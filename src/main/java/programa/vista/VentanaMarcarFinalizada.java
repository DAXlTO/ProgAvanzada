package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;

import javax.swing.*;
import java.awt.*;

public class VentanaMarcarFinalizada extends JFrame implements Vista{
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

        String[] listaTareas = controlador.getTareas(modelo);
        JLabel nombre = new JLabel("Nombre de la tarea: ");
        JComboBox tareas = new JComboBox(listaTareas);
        contenedor.add(tareas);

        String[] cadena = {"Documento","PaginaWeb","Programa"};
        JLabel tipo = new JLabel("Resultado: ");
        JComboBox type = new JComboBox(cadena);
        type.addActionListener(new BotonResultado(cadena[type.getSelectedIndex()]));
        JLabel horas = new JLabel("¿Cuantas horas se han trabajado? ");
        JTextField respuestaHoras = new JTextField(20);

        JLabel formato = new JLabel("¿Que formato se ha utilizado? ");
        JTextField respuestaFormato = new JTextField(20);

        contenedor.add(nombre);
        contenedor.add(tareas);
        contenedor.add(horas);
        contenedor.add(respuestaHoras);
        contenedor.add(formato);
        contenedor.add(respuestaFormato);
        contenedor.add(tipo);
        contenedor.add(type);
        contenedor.setLayout(new FlowLayout());

        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        //boton.addActionListener(actionEvent -> controlador.finalizarTarea(listaTareas[tareas.getSelectedIndex()],type.getSelectedIndex(), modelo));

        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaMarcarFinalizada(controlador, modelo,ventana).ejecuta(modelo);
    }

    @Override
    public String getEntrada() {
        return null;
    }
}
