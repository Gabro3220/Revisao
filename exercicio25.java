import java.util.ArrayDeque;
import java.util.Deque;

public class exercicio25 {
    public static void main(String[] args) {
        Deque<String> pilhaLivros = new ArrayDeque<>();
        
        pilhaLivros.push("Dom Casmurro");
        pilhaLivros.push("O Cortiço");
        pilhaLivros.push("Grande Sertão: Veredas");
        
        System.out.println("Pilha de livros: " + pilhaLivros);
        
        String livroRemovido = pilhaLivros.pop();
        System.out.println("Livro removido (pop): " + livroRemovido);
        System.out.println("Pilha após remoção: " + pilhaLivros);
        
        String livroTopo = pilhaLivros.peek();
        System.out.println("Livro no topo (peek): " + livroTopo);
        System.out.println("Pilha após peek: " + pilhaLivros);
    }
} 