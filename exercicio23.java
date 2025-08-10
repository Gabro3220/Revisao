import java.util.HashMap;
import java.util.Scanner;

public class exercicio23 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        HashMap<String, String> agenda = new HashMap<>();
        
        agenda.put("João", "11999999999");
        agenda.put("Maria", "11888888888");
        agenda.put("Pedro", "11777777777");
        agenda.put("Ana", "11666666666");
        
        System.out.println("Agenda atual: " + agenda);
        
        System.out.print("Digite um nome para verificar se existe: ");
        String nomeBusca = leitor.nextLine();
        
        if (agenda.containsKey(nomeBusca)) {
            System.out.println("Nome encontrado na agenda!");
        } else {
            System.out.println("Nome não encontrado na agenda.");
        }
        
        System.out.print("Digite um telefone para verificar se existe: ");
        String telefoneBusca = leitor.nextLine();
        
        if (agenda.containsValue(telefoneBusca)) {
            System.out.println("Telefone encontrado na agenda!");
        } else {
            System.out.println("Telefone não encontrado na agenda.");
        }
        
        leitor.close();
    }
} 