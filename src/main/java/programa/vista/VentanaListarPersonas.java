package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaListarPersonas extends JFrame{

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaListarPersonas(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de alta tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        List<Persona> personas = controlador.getPersonas(modelo);
        String html = "<html>"+"Lista de personas del proyecto:<br><ol>";
        for (int i = 0; i < personas.size();i++){
            html +=  "<li>" + "Nombre: " + personas.get(i).getNombre() + "<br>Correo: " +personas.get(i).getEmail() +"</li>";
        }

        html += "<ol></html>";

        JLabel etiqueta = new JLabel(html);
        ventana.add(etiqueta);
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
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
        new VentanaListarPersonas(controlador, modelo,ventana).ejecuta();
    }

}
