package programa.vista;

import programa.modelo.clases.Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaTarea implements ActionListener {

    private Proyecto proyecto;

    public BotonAltaTarea(Proyecto proyecto){
        this.proyecto = proyecto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de añadir una tarea.");
        VentanaAltaTarea.main(proyecto);
    }
}
