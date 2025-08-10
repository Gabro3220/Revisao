import java.util.TreeSet;

public class exercicio16 {
    public static void main(String[] args) {
        TreeSet<String> nomes = new TreeSet<>();
        
        nomes.add("Zeca");
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Beatriz");
        nomes.add("Daniel");
        
        System.out.println("Nomes em ordem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
} 