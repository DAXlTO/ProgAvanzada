package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Tarea;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class VentanaListaTareas extends JFrame implements Vista {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;

    private VentanaListaTareas(Controlador controlador, Modelo modelo, JFrame ventanAnterior){
        super("");
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Listado de tareas");
        JPanel contenedor  = new JPanel();
        ventana.add(contenedor);
        Map<String, Tarea> listaTareas = controlador.getTareas1(modelo);
        String html = "<html>"+"Lista de tareas del proyecto:<br><ol>";
        for (Map.Entry<String,Tarea> entrada : listaTareas.entrySet()){
        //for (int i = 0; i < listaTareas.length ;i++){
            html += "<li>" + "Nombre: " + entrada.getValue().getTitulo() + "\n"
                    + "Tipo de tarea: " + entrada.getValue().getTipo() + "\n"
                    + "Coste: " + entrada.getValue().getResultado() +"</li>";
        }
        html += "<ol></html>";

        JLabel etiqueta = new JLabel(html);
        ventana.add(etiqueta);
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.pack();
        ventana.setVisible(true);

    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaListaTareas(controlador, modelo,ventana).ejecuta();
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
