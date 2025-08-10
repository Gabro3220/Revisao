import java.util.TreeMap;

public class exercicio22 {
    public static void main(String[] args) {
        TreeMap<String, Double> notas = new TreeMap<>();
        
        notas.put("Zeca", 8.5);
        notas.put("Ana", 9.0);
        notas.put("Carlos", 7.5);
        notas.put("Beatriz", 8.0);
        notas.put("Daniel", 9.5);
        
        System.out.println("Alunos e notas em ordem alfabética:");
        for (String aluno : notas.keySet()) {
            System.out.println(aluno + ": " + notas.get(aluno));
        }
    }
} 