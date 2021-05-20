package programa.vista;

import programa.controlador.Controlador;
import programa.controlador.ImplementacionControlador;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.ResultadoPaginaWeb;

import javax.swing.*;
import java.awt.*;

public class VentanaResultado extends JFrame {
    String tipo;
    JLabel formato = new JLabel();
    JTextField format = new JTextField();
    JLabel numero = new JLabel();
    JTextField num = new JTextField();
    JLabel espacio = new JLabel();
    JTextField esp = new JTextField();

    private VentanaResultado(String tipo) {
        super("");
        this.tipo = tipo;
    }

    private void ejecuta(){
        Modelo modelo = new Modelo("Pr");
        JFrame ventana = new JFrame("Opciones del Proyecto");
        ventana.addWindowListener(new EscuchadorVentana());
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(0,1,1,10));
        ventana.add(contenedor);
        Controlador con = new ImplementacionControlador();


        if(tipo.equals("Documento")){
            formato = new JLabel("Formato del documento: ");
            format = new JTextField(20);

             numero = new JLabel("Introduce el numero de paginas");
             num = new JTextField(20);

             espacio = new JLabel("Introduce el espacio utilizado");
             esp = new JTextField(20);

        }else if(tipo.equals("PaginaWeb")){
             formato = new JLabel("Estatica o dinamica: ");
             format = new JTextField(20);

             numero = new JLabel("¿En que lenguaje esta desarrolada?");
             num = new JTextField(20);

             espacio = new JLabel("¿Que backend utiliza?");
             esp = new JTextField(20);
        }else{
             formato = new JLabel("Lenguaje: ");
             format = new JTextField(20);

             numero = new JLabel("Numero de lineas");
             num = new JTextField(20);

             espacio = new JLabel("Modulos utilizados");
             esp = new JTextField(20);
        }

        contenedor.setLayout(new FlowLayout());
        contenedor.add(formato);
        contenedor.add(format);
        contenedor.add(numero);
        contenedor.add(num);
        contenedor.add(espacio);
        contenedor.add(esp);


        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String tipo) {
        new VentanaResultado(tipo).ejecuta();
    }

}
