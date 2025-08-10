import java.util.ArrayList;
import java.util.HashSet;

public class exercicio13 {
    public static void main(String[] args) {
        ArrayList<Integer> numerosComDuplicatas = new ArrayList<>();
        
        numerosComDuplicatas.add(1);
        numerosComDuplicatas.add(2);
        numerosComDuplicatas.add(3);
        numerosComDuplicatas.add(2);
        numerosComDuplicatas.add(4);
        numerosComDuplicatas.add(1);
        numerosComDuplicatas.add(5);
        numerosComDuplicatas.add(3);
        
        System.out.println("Lista com duplicatas: " + numerosComDuplicatas);
        
        HashSet<Integer> numerosSemDuplicatas = new HashSet<>(numerosComDuplicatas);
        
        System.out.println("Lista sem duplicatas: " + numerosSemDuplicatas);
    }
} 