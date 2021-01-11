package edd_u5_radix;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> lista = new LinkedList<>();
        lista.add(5);
        lista.add(32);
        lista.add(6);
        lista.add(94);
        lista.add(0);
        lista.add(12);
        lista.add(19);
        lista.add(34);
        lista.add(1);
        System.out.println("Lista Original\n" + lista.toString());
        lista = Radix(lista);
        System.out.println("Lista Ordenada\n" + lista.toString());
    }

    public static List<Integer> Radix(List<Integer> l) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            List<Integer> aux = new LinkedList<>();
            j = 0;
            for (i = 0; i < l.size(); i++) {
                boolean mov = l.get(i) << x > 0;
                if (x == 0 ? !mov : mov) {
                    aux.add(l.get(i));
                    j++;
                } else {
                    l.set(i - j, l.get(i));
                }
            }
            for (i = j; i < l.size(); i++) {
                aux.add(l.get(i - j));
            }
            l = aux;
        }
        return l;
    }
}
