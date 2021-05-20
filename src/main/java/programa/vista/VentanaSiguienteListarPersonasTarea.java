package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaSiguienteListarPersonasTarea extends JFrame implements Vista{

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String tarea;

    private VentanaSiguienteListarPersonasTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior, String tarea) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
        this.tarea = tarea;
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Listado de personas de la tarea " + tarea);
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);

        String[] personas = controlador.getPersonasTarea(tarea, modelo);
        String html = "<html>"+"Lista de personas del proyecto:<br><ol>";
        for (int i = 0; i < personas.length ;i++){
            html +=  "<li>" + "Nombre: " + personas[i] +"</li>";
        }

        html += "<ol></html>";

        JLabel etiqueta = new JLabel(html);
        ventana.add(etiqueta);
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        boton.addActionListener(actionEvent -> ventana.setVisible(false) );
        contenedor.add(boton);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana, String tarea) {
        new VentanaSiguienteListarPersonasTarea(controlador, modelo,ventana,tarea).ejecuta();
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
