package programa.vista;

import programa.controlador.Controlador;
import programa.modelo.clases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaSiguienteFinalizarTarea extends JFrame implements Vista {
    private Controlador controlador;
    private Modelo modelo;
    JFrame ventanAnterior;
    String tarea;
    private JTextField campo1;
    JLabel enun1;
    private JTextField campo2;
    JLabel enun2;
    private JTextField campo3;
    JLabel enun3;
    JTextField identificador;
    JTextField time;
    JTextField comer;

    private VentanaSiguienteFinalizarTarea(Controlador controlador, Modelo modelo, JFrame ventanAnterior, String tarea) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.ventanAnterior=ventanAnterior;
        this.tarea = tarea;

    }

    public void ejecuta(){

        JFrame ventana = new JFrame("Añadir una persona a una tarea");
        JPanel contenedor = new JPanel();
        ventana.add(contenedor);
        Resultado resultado;

        JLabel iden = new JLabel("Identificador de la tarea: ");
        identificador = new JTextField(20);
        contenedor.add(iden);
        contenedor.add(identificador);

        String tipo = controlador.getTarea(modelo,tarea).getTipo();

        JLabel horas = new JLabel("Introduce las horas utilizadas: ");
        time = new JTextField(20);
        contenedor.add(horas);
        contenedor.add(time);

        JLabel inter = new JLabel("Introduce Interno o Comercial: ");
        comer = new JTextField(20);
        contenedor.add(inter);
        contenedor.add(comer);
        System.out.println(tipo);
       if(tipo.equals("Documento")){
            enun1 = new JLabel("Introduce el formato");
            campo1 = new JTextField(20);
            enun2 = new JLabel("Introduce el numero de paginas");
            campo2 = new JTextField(20);
            enun3 = new JLabel("Introduce el espacio utilizado: ");
            campo3 = new JTextField(20);
       }else if(tipo.equals("PaginaWeb")){
           enun1 = new JLabel("Estatica o dinamica");
           campo1 = new JTextField(20);
           enun2 = new JLabel("Lenguaje en que esta desarrolada");
           campo2 = new JTextField(20);
           enun3 = new JLabel("Backend utilizado: ");
           campo3 = new JTextField(20);
       }else{
           enun1 = new JLabel("Introduce el lenguaje");
           campo1 = new JTextField(20);
           enun2 = new JLabel("Introduce el numero de lineas");
           campo2 = new JTextField(20);
           enun3 = new JLabel("Introduce el numero de modulos: ");
           campo3 = new JTextField(20);
       }
        contenedor.add(enun1);
        contenedor.add(campo1);
        contenedor.add(enun2);
        contenedor.add(campo2);
        contenedor.add(enun3);
        contenedor.add(campo3);

        contenedor.setLayout(new FlowLayout());
        JButton boton = new JButton("Volver");
        contenedor.add(boton);

        boton = new JButton("Aceptar");
        boton.addActionListener(actionEvent -> controlador.finalizarTarea(tarea,tipo,identificador.getText(),time.getText(),comer.getText(),campo1.getText(),campo2.getText(),campo3.getText(),modelo));
        boton.addActionListener(aceptar(ventana));
        contenedor.add(boton);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(Controlador controlador, Modelo modelo, JFrame ventana, String tarea) {
        new VentanaSiguienteFinalizarTarea(controlador, modelo,ventana,tarea).ejecuta();
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
