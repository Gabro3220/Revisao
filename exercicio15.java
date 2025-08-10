import java.util.LinkedHashSet;

public class exercicio15 {
    public static void main(String[] args) {
        LinkedHashSet<String> diasSemana = new LinkedHashSet<>();
        
        diasSemana.add("Quarta");
        diasSemana.add("Segunda");
        diasSemana.add("Sexta");
        diasSemana.add("Terça");
        diasSemana.add("Domingo");
        diasSemana.add("Quinta");
        diasSemana.add("Sábado");
        
        System.out.println("Dias da semana na ordem de inserção:");
        for (String dia : diasSemana) {
            System.out.println(dia);
        }
    }
} 