package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaSiguienteFinalizarTarea extends JFrame implements Vista {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String tarea;
    String tipo;
    private JTextField campo1;
    JLabel enun1;
    private JTextField campo2;
    JLabel enun2;
    private JTextField campo3;
    JLabel enun3;


    private VentanaSiguienteFinalizarTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior, String tarea, String tipo) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
        this.tarea = tarea;
        this.tipo=tipo;
    }

    public void ejecuta(){

        JFrame ventana = new JFrame("Añadir una persona a una tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);


       if(tipo.equals("Documento")){

       }else if(tipo.equals("PaginaWeb")){

       }else{

       }

        contenedor.setLayout(new FlowLayout());
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> controlador.);
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana, String tarea, String tipo) {
        new VentanaSiguienteFinalizarTarea(controlador, modelo,ventana,tarea,tipo).ejecuta();
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
