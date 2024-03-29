package programa.modelo.clases;

import programa.modelo.interfaces.Importe;
import programa.modelo.interfaces.tieneClave;
import programa.modelo.interfaces.tieneLista;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements tieneLista, tieneClave, Serializable {
    String titulo;
    String descripcion;
    private List<Persona> personas;
    Persona responsable;
    int prioridad;
    private final LocalDate fechaIni;
    private LocalDate fechaFin;
    Boolean realizada;
    Resultado resultado;
    String etiquetas;
    String tipo;
    Importe importe;

    public Tarea(String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Importe importe){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaIni = LocalDate.now();
        realizada = false;
        personas = new ArrayList<>();
        this.etiquetas = etiquetas;
        this.tipo = tipo;
        this.importe = importe;
    }

    public void finalizarTarea(Resultado resultado){
        realizada = true;
        fechaFin = LocalDate.now();
        this.resultado = resultado;
    }

    public Persona getResponsable(){
        return responsable;
    }

    public void añadirPersona(Persona persona){
        personas.add(persona);
    }

    public void  eliminarPersona(String persona){
        for(int i = 0; i < personas.size();i++){
            if(personas.get(i).nombre.equals(persona)) {
                personas.remove(i);
                break;
            }
        }
    }
    public String getTitulo() {
        return titulo;
    }

    public String getTipo(){return tipo;}
    public List<Persona> getPersonas(){
        return personas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public boolean getRealizada(){return realizada;}

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo;
    }

    public List<Persona> getLista() {
        return personas;
    }

    public void cambiarVariacion(double nuevaCantidad){
        importe.setFacturacion(nuevaCantidad);
    }

    public void cambiarCoste(double coste){
        importe.setCoste(coste);
    }
    public String getClave() {return titulo; }

    public double calcularImporte(){
        return importe.calcularImporte();
    }
}

