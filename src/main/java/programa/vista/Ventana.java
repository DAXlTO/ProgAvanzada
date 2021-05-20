package programa.vista;

import programa.controlador.Controlador;
import programa.controlador.ImplementacionControlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private Modelo modelo;

    private Ventana() {
        super("Inicio");
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Opciones del Proyecto");
        ventana.addWindowListener(new EscuchadorVentana());
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(0,1,1,10));
        ventana.add(contenedor);

        Controlador con = new ImplementacionControlador();
        this.modelo = con.cargarInformacion(new Modelo("pepe"));

        JButton boton = new JButton("Dar de alta a una persona");
        boton.addActionListener(new BotonAltaPersona(con, modelo,ventana)); //Registro escuchador
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Dar de baja a una persona");
        boton.addActionListener(new BotonBajaPersona(con, modelo,ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);


        boton = new JButton("Dar de alta una tarea");
        boton.addActionListener(new BotonAltaTarea(modelo,con,ventana)); //Registro escuchador
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Marcar tarea como finalizada");
        boton.addActionListener(new BotonMarcarFinalizada(con, modelo, ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Añadir una persona a una tarea");
        boton.addActionListener(new BotonAñadirPersonaTarea(con,modelo,ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Eliminar una persona de una tarea");
        boton.addActionListener(new BotonEliminarPersonaTarea(con,modelo,ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Listar personas del proyecto");
        boton.addActionListener(new BotonListarPersonas(con, modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Listar tareas del proyecto");
        boton.addActionListener(new BotonListaTareas(con, modelo, ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Listar las personas de una tarea");
        boton.addActionListener(new BotonListarPersonasTarea(con, modelo, ventana));
        boton.addActionListener(getAvanzar(ventana));
        contenedor.add(boton);

        boton = new JButton("Listar las personas que no son responsables");
        boton.addActionListener(new BotonNoResponsables(con, modelo,ventana));

        contenedor.add(boton);

        boton = new JButton("Listar tareas sin personas");
        contenedor.add(boton);

        boton = new JButton("Guardar y salir");
        boton.addActionListener(new BotonGuardarSalir(con, modelo,ventana));

        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static ActionListener getAvanzar(JFrame ventana){
        return actionEvent -> ventana.setVisible(false);
    }

    public static void main(String[] args) {
        new Ventana().ejecuta();
    }
}


