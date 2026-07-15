package Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UsoColecciones {

    public static void main(String[] args) {
        ejemploarraylist();
        // ejemplolist();
        // usodemap();
    }

    static void ejemploarraylist(){
        Collection listaMarcasCoches = new ArrayList<String>();

        listaMarcasCoches.add("Audi");
        listaMarcasCoches.add("Porsche");
        listaMarcasCoches.add("Aston Martin");
        listaMarcasCoches.add("Ferrari");
        listaMarcasCoches.add("Mercedes");
        listaMarcasCoches.add("Seat");

        System.out.printf("Total de %d elementos almacenados%n",
                listaMarcasCoches.size());

        System.out.println("Elementos existentes en la Coleccion:\n"
                + listaMarcasCoches.toString());

        System.out.println("\nSe borraran elementos Seat y Mercedes de la coleccion\n");
        listaMarcasCoches.remove("Seat");
        listaMarcasCoches.remove("Mercedes");

        System.out.println("Nuevo número elementos almacenados: " +
                listaMarcasCoches.size());
        System.out.println("Elementos:\n" + listaMarcasCoches.toString());
    }

    static void ejemplolist(){
        ArrayList<String> listaPersona = new ArrayList();

        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");

        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " +
                listaPersona + "\n");

        int pos = listaPersona.indexOf("Benjamin Franklin");
        System.out.println("El indice de Benjamin Franklin es: " + pos);

        boolean check = listaPersona.isEmpty();
        System.out.println("Verificando si ArrayList está vacío: " + check);

        int size = listaPersona.size();
        System.out.println("El tamaño de listaPersona es: " + size);

        boolean elemento = listaPersona.contains("Marco Antonio");
        System.out.println(
                "Verificando si 'Marco Antonio' está incluido en listaPersona: " +
                        elemento);

        String item = listaPersona.get(0);
        System.out.println("El elemento con indice 0 es: " + item);

        System.out.println("\nRecuperando elementos del ArrayList con FOR");
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("Indice: " + i + " - Elemento: " +
                    listaPersona.get(i));
        }

        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");
        for (String persona : listaPersona) {
            System.out.println("Elemento: " + persona);
        }

        System.out.println("\nRecuperando elementos del ArrayList con ITERATOR");
        for (Iterator<String> it = listaPersona.iterator(); it.hasNext(); ) {
            System.out.println("Elemento: " + it.next());
        }

        listaPersona.set(1, "Nikola Tesla");
        System.out.println("\nArrayList después de reemplazo:\n" + listaPersona);

        listaPersona.remove(0);
        System.out.println("\nArrayList después de eliminar elemento 0:\n" +
                listaPersona);

        String[] simpleArray = listaPersona.toArray(
                new String[listaPersona.size()]);
        System.out.println("\nObjeto Array creado es:\n" +
                Arrays.toString(simpleArray));
    }

    static void usodemap(){
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        hmap.put(12, "Crayolas");
        hmap.put(2, "Lápices");
        hmap.put(7, "Borradores");
        hmap.put(49, "Colores");
        hmap.put(3, "Boligrafos");

        System.out.println("Contenido de HashMap:");
        Set set = hmap.entrySet();
        Iterator iterador = set.iterator();
        while (iterador.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterador.next();
            System.out.println("Clave: " + mentry.getKey() +
                    " - Valor: " + mentry.getValue());
        }

        String var = hmap.get(2);
        System.out.println("\nValor asociado a clave 2: " + var);

        hmap.remove(3);
        System.out.println(
                "\nHashMap después de eliminar elemento con clave 3:");

        Set set2 = hmap.entrySet();
        Iterator iterador2 = set2.iterator();
        while (iterador2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterador2.next();
            System.out.println("Clave: " + mentry2.getKey() +
                    " - Valor: " + mentry2.getValue());
        }
    }
}