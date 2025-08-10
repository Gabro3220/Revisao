import java.util.HashMap;
import java.util.Scanner;

public class exercicio18 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        HashMap<String, String> dicionario = new HashMap<>();
        
        dicionario.put("casa", "house");
        dicionario.put("carro", "car");
        dicionario.put("livro", "book");
        dicionario.put("água", "water");
        dicionario.put("sol", "sun");
        
        System.out.println("Palavras disponíveis: " + dicionario.keySet());
        System.out.print("Digite uma palavra em português: ");
        String palavra = leitor.nextLine().toLowerCase();
        
        if (dicionario.containsKey(palavra)) {
            String traducao = dicionario.get(palavra);
            System.out.println("Tradução: " + traducao);
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
        
        leitor.close();
    }
} 