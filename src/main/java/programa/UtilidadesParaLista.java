package programa;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaLista<T>{

    public static  <T extends tieneLista> List<T> elementosConListaVacia(List<T> list){
        List<T> solucion = new ArrayList<T>();
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i ++){
                List<T> auxiliar = list.get(i).getLista();
                if (auxiliar.size() == 0)
                        solucion.add(list.get(i));
                }
        }
        return solucion;
    }

    public static <T extends tieneClave> boolean elementosNoRepetidos(List<T> list, T obj){
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i ++){
                if (list.get(i).equals(obj)){
                    return false;
                }
            }
        }
        return true;
    }
 }
