import java.util.LinkedList;

public class exercicio11 {
    public static void main(String[] args) {
        LinkedList<String> fila = new LinkedList<>();
        
        fila.addLast("João");
        fila.addLast("Maria");
        fila.addLast("Pedro");
        fila.addLast("Ana");
        fila.addLast("Carlos");
        
        System.out.println("Fila inicial: " + fila);
        
        String cliente1 = fila.removeFirst();
        String cliente2 = fila.removeFirst();
        System.out.println("Atendidos: " + cliente1 + " e " + cliente2);
        
        fila.addFirst("Prioritário 1");
        fila.addFirst("Prioritário 2");
        
        System.out.println("Fila final: " + fila);
    }
} 