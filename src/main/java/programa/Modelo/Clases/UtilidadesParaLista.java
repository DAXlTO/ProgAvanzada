package programa.Modelo.Clases;

import programa.Modelo.Interfaces.tieneClave;
import programa.Modelo.Interfaces.tieneLista;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaLista<T>{

    public static  <T extends tieneLista> List<T> elementosConListaVacia(List<T> list){
        List<T> solucion = new ArrayList<T>();
        if (list.size() > 0){
            for (T t : list) {
                List<T> auxiliar = t.getLista();
                if (auxiliar.size() == 0)
                    solucion.add(t);
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
