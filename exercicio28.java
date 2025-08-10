import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio28 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Deque<String> pilha = new ArrayDeque<>();
        
        System.out.print("Digite uma frase: ");
        String frase = leitor.nextLine();
        
        String[] palavras = frase.split("\\s+");
        
        for (String palavra : palavras) {
            pilha.push(palavra);
        }
        
        System.out.print("Frase invertida: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
        
        leitor.close();
    }
} 