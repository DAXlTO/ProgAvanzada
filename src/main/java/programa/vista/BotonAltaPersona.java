package programa.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAltaPersona implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el botón de dar de alta a una persona.");
        VentanaAltaPersona.main("");
    }
}

