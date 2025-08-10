import java.util.ArrayList;
import java.util.Collections;

public class exercicio10 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        
        numeros.add(23);
        numeros.add(7);
        numeros.add(45);
        numeros.add(12);
        numeros.add(89);
        numeros.add(3);
        numeros.add(67);
        numeros.add(34);
        numeros.add(18);
        numeros.add(56);
        
        System.out.println("Lista original: " + numeros);
        
        Collections.sort(numeros);
        
        System.out.println("Lista ordenada: " + numeros);
    }
} 