import java.util.LinkedList;

public class exercicio29 {
    private static LinkedList<String> historico = new LinkedList<>();
    private static int posicaoAtual = -1;
    
    public static void visitar(String url) {
        while (posicaoAtual < historico.size() - 1) {
            historico.removeLast();
        }
        historico.add(url);
        posicaoAtual++;
        System.out.println("Visitando: " + url);
    }
    
    public static void voltar() {
        if (posicaoAtual > 0) {
            posicaoAtual--;
            System.out.println("Voltando para: " + historico.get(posicaoAtual));
        } else {
            System.out.println("Não é possível voltar mais.");
        }
    }
    
    public static void avancar() {
        if (posicaoAtual < historico.size() - 1) {
            posicaoAtual++;
            System.out.println("Avançando para: " + historico.get(posicaoAtual));
        } else {
            System.out.println("Não é possível avançar mais.");
        }
    }
    
    public static void main(String[] args) {
        visitar("www.google.com");
        visitar("www.github.com");
        visitar("www.stackoverflow.com");
        
        voltar();
        voltar();
        avancar();
        avancar();
        
        System.out.println("Histórico completo: " + historico);
    }
} 