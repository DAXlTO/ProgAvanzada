package programa.vista;

import programa.modelo.clases.Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonBajaPersona implements ActionListener {

    private Proyecto proyecto;

    public BotonBajaPersona(Proyecto proyecto){
        this.proyecto = proyecto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de baja a una persona.");
        VentanaBajaPersona.main(proyecto);
    }
}
