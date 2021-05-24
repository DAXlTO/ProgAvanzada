package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaNoResponsables extends JFrame{
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaNoResponsables(Controlador controlador, Modelo modelo, JFrame ventanAnterior) {
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    private void ejecuta() {
        JFrame ventana = new JFrame("Dar de alta tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        List<Persona> personas = controlador.listarPersonasNoResponsables(modelo);
        String html = "<html>"+"Lista de personas del proyecto que no son responsables:<br><ol>";
        for (int i = 0; i < personas.size();i++){
            html +=  "<li>" + "Nombre: " + personas.get(i).getNombre() + "<br>Correo: " +personas.get(i).getEmail() +"</li>";
        }
        html += "<ol></html>";

        JLabel etiqueta = new JLabel(html);
        ventana.add(etiqueta);
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaNoResponsables(controlador, modelo,ventana).ejecuta();
    }

}
