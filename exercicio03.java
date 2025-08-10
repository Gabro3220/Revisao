import java.util.Scanner;
import java.util.Random;

public class exercicio03 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random gerador = new Random();
        
        int numeroSecreto = gerador.nextInt(100) + 1;
        int palpite;
        int tentativas = 0;
        
        System.out.println("Tente adivinhar um número entre 1 e 100!");
        
        do {
            System.out.print("\nDigite seu palpite: ");
            palpite = leitor.nextInt();
            tentativas++;
            
            if (palpite > numeroSecreto) {
                System.out.println("Numero alto! Tente um número menor.");
            } else if (palpite < numeroSecreto) {
                System.out.println("Numero baixo! Tente um número maior.");
            } else {
                System.out.println("Parabéns! Você acertou!");
                System.out.println("Número de tentativas: " + tentativas);
            }
        } while (palpite != numeroSecreto);
        
        leitor.close();
    }
} 