import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        int num;
        
        System.out.print("Digite um número inteiro: ");
        num = leitor.nextInt();
        
        System.out.println("\nTabuada do " + num + ":");
        
        for (int i = 1; i <= 10; i++) {
            int resultado = num * i;
            System.out.println(num + " x " + i + " = " + resultado);
        }
        
        leitor.close();
    }
} 