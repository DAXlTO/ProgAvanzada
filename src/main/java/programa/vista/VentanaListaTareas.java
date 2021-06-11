package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Tarea;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class VentanaListaTareas extends JFrame  {

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
        Map<String, Tarea> listaTareas = modelo.getTareas();
        float coste = 0;
        String html = "<html>"+"Lista de tareas del proyecto:<br><ol>";
        for (String key : listaTareas.keySet()){
            html += "<li>" + "Nombre: " + listaTareas.get(key).getTitulo() + "\n"
                    + "Responsable (" + listaTareas.get(key).getResponsable() + ")\n"
                    + "Tipo de tarea: " +listaTareas.get(key).getTipo() + "\n"
                    + "Coste: " + listaTareas.get(key).calcularImporte() + "\n" + "</li>";
                    coste += listaTareas.get(key).calcularImporte();
        }

        html += "Coste total del proyecto: " + coste + "<ol></html>";

        JLabel etiqueta = new JLabel(html);
        ventana.add(etiqueta);
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.setSize(600,300);
        ventana.setVisible(true);

    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana) {
        new VentanaListaTareas(controlador, modelo,ventana).ejecuta();
    }

    public ActionListener aceptar(JFrame ventana){
        ventanAnterior.setVisible(true);
        return actionEvent -> ventana.setVisible(false);
    }


}
