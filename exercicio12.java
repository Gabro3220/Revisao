import java.util.ArrayList;
import java.util.Scanner;

public class exercicio12 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> cidades = new ArrayList<>();
        
        cidades.add("São Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Salvador");
        cidades.add("Brasília");
        cidades.add("Fortaleza");
        cidades.add("Curitiba");
        cidades.add("Recife");
        
        System.out.println("Cidades disponíveis: " + cidades);
        System.out.print("Digite o nome de uma cidade: ");
        String cidadeBusca = leitor.nextLine();
        
        if (cidades.contains(cidadeBusca)) {
            int indice = cidades.indexOf(cidadeBusca);
            System.out.println("Cidade encontrada no índice: " + indice);
        } else {
            System.out.println("Cidade não encontrada na lista.");
        }
        
        leitor.close();
    }
} 