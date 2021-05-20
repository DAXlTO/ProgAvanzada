package programa.modelo.clases;

import programa.modelo.interfaces.tieneClave;
import programa.modelo.interfaces.tieneLista;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaLista<T>{

    public static  <T extends tieneLista> List<T> elementosConListaVacia(List<T> list){
        List<T> solucion = new ArrayList<T>();
        if (list.size() > 0){
            for (T t : list) {
                List<T> auxiliar = t.getLista();
                if (auxiliar.size() == 0){
                    solucion.add(t);
                    System.out.println(t);
                }
            }
        }
        return solucion;
    }

    public static <T extends tieneClave> boolean elementosNoRepetidos(List<T> list, T obj){
        for (T t : list) {
            if (t.getClave().equals(obj.getClave())) {
                return false;
            }
        }
        return true;
    }
 }
