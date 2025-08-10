import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        double n1, n2, n3, media;
        
        System.out.print("Digite a primeira nota: ");
        n1 = leitor.nextDouble();
        
        System.out.print("Digite a segunda nota: ");
        n2 = leitor.nextDouble();
        
        System.out.print("Digite a terceira nota: ");
        n3 = leitor.nextDouble();
        
        media = (n1 + n2 + n3) / 3.0;
        
        System.out.printf("\nMédia do aluno: %.2f\n", media);
        
        if (media >= 7.0) {
            System.out.println("Situação: Aprovado");
        } else if (media >= 5.0) {
            System.out.println("Situação: Recuperação");
        } else {
            System.out.println("Situação: Reprovado");
        }
        
        leitor.close();
    }
}
