import java.util.HashMap;
import java.util.Scanner;

public class exercicio20 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        HashMap<String, String> agenda = new HashMap<>();
        int opcao;

        do {
            System.out.println("\n=== Agenda de Contatos ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Buscar telefone por nome");
            System.out.println("3. Listar todos os contatos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = leitor.nextLine();
                    agenda.put(nome, telefone);
                    System.out.println("Contato adicionado!");
                    break;
                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String nomeBusca = leitor.nextLine();
                    if (agenda.containsKey(nomeBusca)) {
                        System.out.println("Telefone: " + agenda.get(nomeBusca));
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 3:
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vazia!");
                    } else {
                        System.out.println("Contatos:");
                        for (String contato : agenda.keySet()) {
                            System.out.println(contato + ": " + agenda.get(contato));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        leitor.close();
    }
} 