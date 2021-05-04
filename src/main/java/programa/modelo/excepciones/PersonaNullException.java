package programa.modelo.excepciones;

public class PersonaNullException extends Exception{
    public PersonaNullException(){
        super("No hay personas");
    }
}
