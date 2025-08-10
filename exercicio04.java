public class exercicio04 {
    public static void main(String[] args) {
        int[] numeros = {2, 7, 4, 9, 12, 15, 8, 3};
        int soma = 0;
        for (int n : numeros) {
            if (n % 2 != 0) {
                soma += n;
            }
        }
        System.out.println("Soma dos ímpares: " + soma);
    }
} 