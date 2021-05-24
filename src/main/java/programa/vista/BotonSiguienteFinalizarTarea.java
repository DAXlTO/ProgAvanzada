package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonSiguienteFinalizarTarea implements ActionListener {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;
    String tarea;


    public BotonSiguienteFinalizarTarea(Controlador controlador, Modelo modelo, JFrame ventana, String nomTarea){
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventana=ventana;
        this.tarea = nomTarea;
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        System.out.println("Has pulsado el boton de finaliza una tarea");
        VentanaSiguienteFinalizarTarea.main(controlador,modelo,ventana,tarea);
    }
}
