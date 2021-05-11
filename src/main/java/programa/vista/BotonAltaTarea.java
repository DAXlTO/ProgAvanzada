package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaTarea implements ActionListener {

    private Proyecto proyecto;
    private Controlador controlador;

    public BotonAltaTarea(Proyecto proyecto, Controlador controlador){
        this.proyecto = proyecto;
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de añadir una tarea.");
        VentanaAltaTarea.main(proyecto);
    }
}
