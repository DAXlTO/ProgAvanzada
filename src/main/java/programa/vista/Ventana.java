package programa.vista;

import javax.swing.*;

public class Ventana extends JFrame {
    private Ventana() {
        super("Primera Ventana");
    }
    private void ejecuta() {
        setSize(400, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Ventana().ejecuta();
    }
}


