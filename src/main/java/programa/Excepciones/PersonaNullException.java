package programa.Excepciones;

public class PersonaNullException extends Exception{
    public PersonaNullException(){
        super("No hay personas");
    }
}
