package programa.controlador;

import programa.modelo.clases.*;
import programa.modelo.excepciones.TareaRepetidaException;
import programa.modelo.interfaces.Importe;
import java.util.List;
import java.util.Map;

public class ImplementacionControlador implements Controlador{
    private Modelo modelo;

    public void altaPersona(String nombre, String email, Modelo modelo) {
        this.modelo = modelo;
        Persona persona = new Persona(nombre,email);
        this.modelo.altaPersona(persona);
    }

    public List<Persona> getPersonas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.getPersonas();
    }

    public String[] getTareas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.tareas();
    }

    public Map<String, Tarea> getTareas1(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.getTareas();
    }

    public String[] getPersonasTarea(String tarea){
        return modelo.getPersonasTarea(tarea);
    }

    public boolean darBajaPersonaTarea(String persona, String tarea, Modelo modelo){
        System.out.println(tarea);
        this.modelo = modelo;
        return modelo.eliminarPersonaDeTarea(persona,tarea);
    }
    public void eliminarPersona(int persona, Modelo modelo){
        this.modelo = modelo;
        this.modelo.eliminarPersona(persona);
    }

    public Tarea getTarea(Modelo modelo, String tarea){
        return modelo.getTarea(tarea);
    }

    public void finalizarTarea(String tarea, String tipo,String idem,String time, String internoCOmercial,String camp1,String camp2,String camp3, Modelo modelo){
        this.modelo = modelo;
        Resultado resultado = new Resultado();
        System.out.println(tarea+ " ######" +tipo+ " ######"+idem+ " ######"+time+ " ######"+internoCOmercial+ " ######"+camp1+ " ######"+camp2+ " ######"+camp3);
        if(tipo.equals("Documento")){
           resultado = new ResultadoDocumento(idem,Integer.parseInt(time),internoCOmercial,camp1,Integer.parseInt(camp2),Float.parseFloat(camp3));
        }else if(tipo.equals("PaginaWeb")){
            resultado = new ResultadoPaginaWeb(idem,Integer.parseInt(time),internoCOmercial,camp1,camp2,camp3);
        }else{
            resultado = new ResultadoPrograma(idem,Integer.parseInt(time),internoCOmercial,camp1,Integer.parseInt(camp2),Integer.parseInt(camp3));
        }
        modelo.finalizarTarea(tarea,resultado);
    }

    public Modelo cargarInformacion(Modelo modelo){
        return modelo.cargarInformacion();
    }

    public List<Persona> listarPersonasNoResponsables(Modelo modelo){
        return modelo.listarPersonasNoResponsables();
    }

    public List<Tarea> listarTareasSinPersonas(Modelo modelo){
        return modelo.listarTareasSinPersonas(modelo);
    }

    public boolean añadirPersonaATarea(String tarea, String persona, Modelo modelo){
        System.out.println(tarea);
        System.out.println(persona);
        this.modelo = modelo;
        this.modelo.añadirPersonaATarea(tarea, persona);
        return true;
    }
    public void guardaSalir(Modelo modelo){
        this.modelo = modelo;
        modelo.almacenarInformacion(modelo);
    }

    public void modificarCostes(String tarea, double var, double coste){

    }

    public List<String> getTareasNoFinalizadas(Modelo modelo){
        return modelo.getTareasNoFinalizadas();
    }


    public void altaTarea(Modelo modelo, String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Double coste, String importe, float variacion){
        this.modelo = modelo;

        Importe impor = modelo.comprobarImporte(variacion, importe,coste);
        Tarea tarea = new Tarea(titulo,descripcion,responsable,prioridad,etiquetas,tipo,coste,impor);
        try {
            System.out.println(titulo);
            modelo.añadirTarea(tarea);
        } catch (TareaRepetidaException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] getPersonasTarea(String tarea, Modelo modelo) {
        this.modelo = modelo;
        return modelo.getPersonasTarea(tarea);
    }

    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }

}
