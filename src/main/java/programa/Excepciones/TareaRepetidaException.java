package programa.Excepciones;

public class TareaRepetidaException extends Exception{
    public TareaRepetidaException(){
        super("La tarea esta repetida");
    }
}
