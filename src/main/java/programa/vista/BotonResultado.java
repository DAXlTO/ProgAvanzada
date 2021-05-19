package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.Modelo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonResultado implements ActionListener {

    private Controlador controlador;
    private Modelo modelo;
    JFrame ventana;
    String tipo;

    public BotonResultado(String tipo){
        this.tipo = tipo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsaste el tipo de resultado.");
        System.out.println(tipo);
        VentanaResultado.main(tipo);
    }
}

