import java.util.ArrayList;
import java.util.Scanner;

public class exercicio09 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa por índice");
            System.out.println("3. Listar todas as tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = leitor.nextLine();
                    tarefas.add(tarefa);
                    System.out.println("Tarefa adicionada!");
                    break;
                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        System.out.print("Digite o índice da tarefa: ");
                        int indice = leitor.nextInt();
                        if (indice >= 0 && indice < tarefas.size()) {
                            tarefas.remove(indice);
                            System.out.println("Tarefa removida!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;
                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                    } else {
                        System.out.println("Tarefas:");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println(i + ". " + tarefas.get(i));
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