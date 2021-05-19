package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaAltaTarea extends JFrame{

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaAltaTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta(Modelo modelo) {
        JFrame ventana = new JFrame("Dar de alta tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);


        JLabel nom = new JLabel("Nombre de la tarea: ");
        JTextField nombre = new JTextField(20);

        JLabel descr = new JLabel("Descripcion: ");
        JTextField des = new JTextField(20);


        List<Persona> personas = controlador.getPersonas(modelo);
        JLabel resp = new JLabel("Personas responsable: ");
        String[] persona = new String[personas.size()];
        for (int i = 0; i < personas.size();i++){
            persona[i]=personas.get(i).getNombre();
        }
        JComboBox per = new JComboBox(persona);

        String[] intervalo = {"1","2","3","4","5"};
        JLabel prioridad = new JLabel("Priotidad de la tarea: ");
        JComboBox prio = new JComboBox(intervalo);

        JLabel etiqueta = new JLabel("Introduce una etiqueta :");
        JTextField eti = new JTextField(15);

        String[] cadena = {"Documento","PaginaWeb","Programa"};
        JLabel tipo = new JLabel("Priotidad de la tarea: ");
        JComboBox type = new JComboBox(cadena);

        JFormattedTextField textField1 = new JFormattedTextField (new Float(5));
        JLabel coste = new JLabel("Introduce el coste de la tarea: ");

        String[] impor = {"Consumo Interno","Descuento","Urgente"};
        JLabel importe = new JLabel("Importe de la tarea: ");
        JComboBox im = new JComboBox(impor);

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nom);
        contenedor.add(nombre);
        contenedor.add(descr);
        contenedor.add(des);
        contenedor.add(resp);
        contenedor.add(per);
        contenedor.add(prioridad);
        contenedor.add(prio);
        contenedor.add(etiqueta);
        contenedor.add(eti);
        contenedor.add(tipo);
        contenedor.add(type);
        contenedor.add(coste);
        contenedor.add(textField1);
        contenedor.add(importe);
        contenedor.add(im);


        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        boton.addActionListener(actionEvent -> controlador.altaTarea(modelo,nombre.getText(),des.getText(),personas.get(per.getSelectedIndex()),Integer.parseInt(prio.getSelectedItem().toString()),eti.getText(),type.getSelectedItem().toString(),Double.parseDouble(textField1.getText()),im.getSelectedItem().toString()));
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaAltaTarea(controlador, modelo,ventana).ejecuta(modelo);
    }

}
