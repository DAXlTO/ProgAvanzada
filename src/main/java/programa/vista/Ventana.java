package programa.vista;

import programa.controlador.Controlador;
import programa.controlador.ImplementacionControlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        modelo = con.cargarInformacion(new Modelo("Proyecto"));

        JButton boton = new JButton("Dar de alta a una persona");
        boton.addActionListener(new BotonAltaPersona(con, modelo,ventana)); //Registro escuchador
        contenedor.add(boton);

        boton = new JButton("Dar de baja a una persona");
        boton.addActionListener(new BotonBajaPersona(con, modelo,ventana));
        contenedor.add(boton);


        boton = new JButton("Dar de alta una tarea");
        boton.addActionListener(new BotonAltaTarea(modelo,con,ventana)); //Registro escuchador
        contenedor.add(boton);

        boton = new JButton("Marcar tarea como finalizada");
        boton.addActionListener(new BotonMarcarFinalizada(con, modelo, ventana));
        contenedor.add(boton);

        boton = new JButton("Añadir una persona a una tarea");
        boton.addActionListener(new BotonAñadirPersonaTarea(con,modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Eliminar una persona de una tarea");
        boton.addActionListener(new BotonEliminarPersonaTarea(con,modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Modificar el coste de una tarea");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
                VentanaModificarCoste.main(con,modelo,ventana);
            }
        });
        contenedor.add(boton);

        boton = new JButton("Listar personas del proyecto");
        boton.addActionListener(new BotonListarPersonas(con, modelo,ventana));
        contenedor.add(boton);

        boton = new JButton("Listar tareas del proyecto");
        boton.addActionListener(new BotonListaTareas(con, modelo, ventana));
        contenedor.add(boton);

        boton = new JButton("Listar las personas de una tarea");
        boton.addActionListener(new BotonListarPersonasTarea(con, modelo, ventana));
        contenedor.add(boton);

        boton = new JButton("Listar las personas que no son responsables");
        boton.addActionListener(new BotonNoResponsables(con, modelo,ventana));

        contenedor.add(boton);

        boton = new JButton("Listar tareas sin personas");
        boton.addActionListener(new BotonListarTareaSinPersonas(modelo,con,ventana));



        contenedor.add(boton);


        boton = new JButton("Guardar y salir");
        boton.addActionListener(new BotonGuardarSalir(con, modelo,ventana));

        contenedor.add(boton);
        ventana.setLocationRelativeTo(null);
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


