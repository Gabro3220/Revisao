import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class exercicio27 {
    public static void main(String[] args) {
        ArrayList<String> participantes = new ArrayList<>();
        
        participantes.add("João");
        participantes.add("Maria");
        participantes.add("Pedro");
        participantes.add("Ana");
        participantes.add("João");
        participantes.add("Carlos");
        participantes.add("Maria");
        participantes.add("Beatriz");
        participantes.add("Pedro");
        participantes.add("Daniel");
        
        System.out.println("Lista original: " + participantes);
        
        List<String> ganhadores = realizarSorteio(participantes, 3);
        
        System.out.println("Ganhadores sorteados: " + ganhadores);
    }
    
    public static List<String> realizarSorteio(List<String> participantes, int numGanhadores) {
        HashSet<String> participantesUnicos = new HashSet<>(participantes);
        ArrayList<String> listaUnicos = new ArrayList<>(participantesUnicos);
        ArrayList<String> ganhadores = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("Participantes únicos: " + listaUnicos);
        
        for (int i = 0; i < numGanhadores && i < listaUnicos.size(); i++) {
            int indice = random.nextInt(listaUnicos.size());
            ganhadores.add(listaUnicos.get(indice));
            listaUnicos.remove(indice);
        }
        
        return ganhadores;
    }
} 