import java.util.HashMap;

public class exercicio19 {
    public static void main(String[] args) {
        String texto = "A previsão do tempo para esse feriado é de muito sol, altas temperaturas e noites com o céu limpo de nuvens, preparem-se pois o verão será intenso.";
        HashMap<String, Integer> frequencia = new HashMap<>();
        
        String[] palavras = texto.toLowerCase().split("\\s+");
        
        for (String palavra : palavras) {
            palavra = palavra.replaceAll("[^a-zA-Z]", "");
            if (!palavra.isEmpty()) {
                frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
            }
        }
        
        System.out.println("Frequência de palavras:");
        for (String palavra : frequencia.keySet()) {
            System.out.println(palavra + ": " + frequencia.get(palavra));
        }
    }
} 