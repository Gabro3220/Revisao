import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nome + " - Nota: " + nota;
    }
}

public class exercicio30 {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        
        alunos.add(new Aluno("João", 8.5));
        alunos.add(new Aluno("Maria", 6.0));
        alunos.add(new Aluno("Pedro", 4.5));
        alunos.add(new Aluno("Ana", 9.0));
        alunos.add(new Aluno("Carlos", 5.5));
        alunos.add(new Aluno("Beatriz", 3.0));
        alunos.add(new Aluno("Daniel", 7.5));
        
        Map<String, List<Aluno>> grupos = agruparPorNota(alunos);
        
        for (String categoria : grupos.keySet()) {
            System.out.println("\n" + categoria + ":");
            for (Aluno aluno : grupos.get(categoria)) {
                System.out.println("  " + aluno);
            }
        }
    }
    
    public static Map<String, List<Aluno>> agruparPorNota(List<Aluno> alunos) {
        Map<String, List<Aluno>> grupos = new HashMap<>();
        grupos.put("Aprovados", new ArrayList<>());
        grupos.put("Recuperação", new ArrayList<>());
        grupos.put("Reprovados", new ArrayList<>());
        
        for (Aluno aluno : alunos) {
            if (aluno.getNota() >= 7.0) {
                grupos.get("Aprovados").add(aluno);
            } else if (aluno.getNota() >= 5.0) {
                grupos.get("Recuperação").add(aluno);
            } else {
                grupos.get("Reprovados").add(aluno);
            }
        }
        
        return grupos;
    }
} 