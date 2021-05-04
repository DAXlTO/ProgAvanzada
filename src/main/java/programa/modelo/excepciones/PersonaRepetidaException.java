package programa.modelo.excepciones;

public class PersonaRepetidaException extends Exception{
    public PersonaRepetidaException() {
        super ("La persona ya existe");
    }
}
