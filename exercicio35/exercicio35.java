package exercicio35;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

enum TipoSalgadinho {
    FRITO, ASSADO
}

abstract class Prato {
    protected double precoVenda;
    protected LocalDate dataValidade;
    protected double peso;
    protected String nome;

    public Prato(String nome, double precoVenda, LocalDate dataValidade, double peso) {
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    public abstract double calcularPreco();
    public abstract String getDescricao();

    public double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getPeso() {
        return peso;
    }

    public String getNome() {
        return nome;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(dataValidade);
    }
}
class Pizza extends Prato {
    private String molho;
    private String recheio;
    private String borda;

    public Pizza(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                 String molho, String recheio, String borda) {
        super(nome, precoVenda, dataValidade, peso);
        this.molho = molho;
        this.recheio = recheio;
        this.borda = borda;
    }

    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (borda.toLowerCase().contains("recheada")) {
            precoBase += 5.0;
        }
        
        if (recheio.toLowerCase().contains("especial") || 
            recheio.toLowerCase().contains("premium")) {
            precoBase += 8.0;
        }
        
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return String.format("Pizza %s - Molho: %s, Recheio: %s, Borda: %s (%.2fg)", 
                           nome, molho, recheio, borda, peso);
    }

    public String getMolho() { return molho; }
    public String getRecheio() { return recheio; }
    public String getBorda() { return borda; }
}

class Lanche extends Prato {
    private String pao;
    private String recheio;
    private String molho;

    public Lanche(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                  String pao, String recheio, String molho) {
        super(nome, precoVenda, dataValidade, peso);
        this.pao = pao;
        this.recheio = recheio;
        this.molho = molho;
    }

    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (pao.toLowerCase().contains("integral") || 
            pao.toLowerCase().contains("artesanal")) {
            precoBase += 3.0;
        }
        
        if (recheio.toLowerCase().contains("especial") || 
            recheio.toLowerCase().contains("premium")) {
            precoBase += 6.0;
        }
        
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return String.format("Lanche %s - Pão: %s, Recheio: %s, Molho: %s (%.2fg)", 
                           nome, pao, recheio, molho, peso);
    }

    public String getPao() { return pao; }
    public String getRecheio() { return recheio; }
    public String getMolho() { return molho; }
}

class Salgadinho extends Prato {
    private TipoSalgadinho tipo;
    private String massa;
    private String recheio;

    public Salgadinho(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                      TipoSalgadinho tipo, String massa, String recheio) {
        super(nome, precoVenda, dataValidade, peso);
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }

    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (tipo == TipoSalgadinho.ASSADO) {
            precoBase += 2.0;
        }
        
        if (massa.toLowerCase().contains("integral") || 
            massa.toLowerCase().contains("especial")) {
            precoBase += 1.5;
        }
        
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return String.format("Salgadinho %s - Tipo: %s, Massa: %s, Recheio: %s (%.2fg)", 
                           nome, tipo, massa, recheio, peso);
    }

    public TipoSalgadinho getTipo() { return tipo; }
    public String getMassa() { return massa; }
    public String getRecheio() { return recheio; }
}

class Pedido {
    private String nomeCliente;
    private double taxaServico;
    private ArrayList<Prato> itensConsumidos;
    private LocalDate dataPedido;
    private int numeroPedido;
    private static int contadorPedidos = 1;

    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
        this.itensConsumidos = new ArrayList<>();
        this.dataPedido = LocalDate.now();
        this.numeroPedido = contadorPedidos++;
    }

    public void adicionarItem(Prato prato) {
        itensConsumidos.add(prato);
    }

    public void removerItem(Prato prato) {
        itensConsumidos.remove(prato);
    }

    public double calcularTotal() {
        double subtotal = 0.0;
        for (Prato prato : itensConsumidos) {
            subtotal += prato.calcularPreco();
        }
        return subtotal + (subtotal * taxaServico);
    }

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (Prato prato : itensConsumidos) {
            subtotal += prato.calcularPreco();
        }
        return subtotal;
    }

    public void mostrarFatura() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           QUASE TRÊS LANCHES");
        System.out.println("=".repeat(50));
        System.out.println("Pedido #" + numeroPedido);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Data: " + dataPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Hora: " + java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("-".repeat(50));
        
        for (int i = 0; i < itensConsumidos.size(); i++) {
            Prato prato = itensConsumidos.get(i);
            System.out.printf("%d. %s\n", i + 1, prato.getDescricao());
            System.out.printf("   R$ %.2f\n", prato.calcularPreco());
        }
        
        System.out.println("-".repeat(50));
        System.out.printf("Subtotal: R$ %.2f\n", calcularSubtotal());
        System.out.printf("Taxa de Serviço (%.1f%%): R$ %.2f\n", 
                         taxaServico * 100, calcularSubtotal() * taxaServico);
        System.out.println("-".repeat(50));
        System.out.printf("TOTAL: R$ %.2f\n", calcularTotal());
        System.out.println("=".repeat(50));
        System.out.println("Obrigado pela preferência!");
        System.out.println("Volte sempre!");
    }

    public double calcularTroco(double valorRecebido) {
        return valorRecebido - calcularTotal();
    }

    public String getNomeCliente() { return nomeCliente; }
    public double getTaxaServico() { return taxaServico; }
    public ArrayList<Prato> getItensConsumidos() { return itensConsumidos; }
    public LocalDate getDataPedido() { return dataPedido; }
    public int getNumeroPedido() { return numeroPedido; }
}

class SistemaLanchonete {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Prato> cardapio;

    public SistemaLanchonete() {
        this.pedidos = new ArrayList<>();
        this.cardapio = new ArrayList<>();
        inicializarCardapio();
    }

    private void inicializarCardapio() {
        cardapio.add(new Pizza("Margherita", 25.0, LocalDate.now().plusDays(7), 800.0, 
                              "Tomate", "Mussarela", "Tradicional"));
        cardapio.add(new Pizza("Calabresa", 28.0, LocalDate.now().plusDays(7), 850.0, 
                              "Tomate", "Calabresa", "Recheada"));
        cardapio.add(new Pizza("Quatro Queijos", 32.0, LocalDate.now().plusDays(7), 900.0, 
                              "Branco", "Especial", "Recheada"));

        cardapio.add(new Lanche("X-Burger", 15.0, LocalDate.now().plusDays(3), 300.0, 
                               "Hambúrguer", "Carne", "Ketchup"));
        cardapio.add(new Lanche("X-Salada", 18.0, LocalDate.now().plusDays(3), 350.0, 
                               "Integral", "Frango", "Maionese"));
        cardapio.add(new Lanche("X-Bacon", 22.0, LocalDate.now().plusDays(3), 400.0, 
                               "Artesanal", "Especial", "Barbecue"));

        cardapio.add(new Salgadinho("Coxinha", 8.0, LocalDate.now().plusDays(2), 100.0, 
                                   TipoSalgadinho.FRITO, "Tradicional", "Frango"));
        cardapio.add(new Salgadinho("Empada", 7.0, LocalDate.now().plusDays(2), 80.0, 
                                   TipoSalgadinho.ASSADO, "Integral", "Palmito"));
        cardapio.add(new Salgadinho("Risoles", 9.0, LocalDate.now().plusDays(2), 120.0, 
                                   TipoSalgadinho.FRITO, "Especial", "Queijo"));
    }

    public void mostrarCardapio() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    CARDÁPIO");
        System.out.println("=".repeat(60));
        
        System.out.println("\n🍕 PIZZAS:");
        for (int i = 0; i < cardapio.size(); i++) {
            Prato prato = cardapio.get(i);
            if (prato instanceof Pizza) {
                System.out.printf("%d. %s - R$ %.2f\n", i + 1, prato.getDescricao(), prato.calcularPreco());
            }
        }
        
        System.out.println("\n🥪 LANCHES:");
        for (int i = 0; i < cardapio.size(); i++) {
            Prato prato = cardapio.get(i);
            if (prato instanceof Lanche) {
                System.out.printf("%d. %s - R$ %.2f\n", i + 1, prato.getDescricao(), prato.calcularPreco());
            }
        }
        
        System.out.println("\n🥟 SALGADINHOS:");
        for (int i = 0; i < cardapio.size(); i++) {
            Prato prato = cardapio.get(i);
            if (prato instanceof Salgadinho) {
                System.out.printf("%d. %s - R$ %.2f\n", i + 1, prato.getDescricao(), prato.calcularPreco());
            }
        }
        System.out.println("=".repeat(60));
    }

    public Prato selecionarPrato(int indice) {
        if (indice >= 1 && indice <= cardapio.size()) {
            return cardapio.get(indice - 1);
        }
        return null;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           PEDIDOS REALIZADOS");
        System.out.println("=".repeat(50));
        
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido #" + pedido.getNumeroPedido());
            System.out.println("Cliente: " + pedido.getNomeCliente());
            System.out.println("Total: R$ " + String.format("%.2f", pedido.calcularTotal()));
            System.out.println("-".repeat(30));
        }
    }
}

public class exercicio35 {
    public static void main(String[] args) {
        SistemaLanchonete sistema = new SistemaLanchonete();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍕🥪🥟 QUASE TRÊS LANCHES 🥟🥪🍕");
        System.out.println("Sistema de Pedidos - Protótipo Inicial");

        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           MENU PRINCIPAL");
            System.out.println("=".repeat(50));
            System.out.println("1. Ver Cardápio");
            System.out.println("2. Fazer Pedido");
            System.out.println("3. Ver Pedidos Realizados");
            System.out.println("4. Testar Funcionalidades");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    sistema.mostrarCardapio();
                    break;
                    
                case 2:
                    fazerPedido(sistema, scanner);
                    break;
                    
                case 3:
                    sistema.listarPedidos();
                    break;
                    
                case 4:
                    testarFuncionalidades(sistema);
                    break;
                    
                case 5:
                    System.out.println("Obrigado por usar o sistema!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void fazerPedido(SistemaLanchonete sistema, Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        
        System.out.print("Taxa de serviço (ex: 0.1 para 10%): ");
        double taxaServico = scanner.nextDouble();
        
        Pedido pedido = new Pedido(nomeCliente, taxaServico);
        
        sistema.mostrarCardapio();
        
        while (true) {
            System.out.print("Digite o número do item (0 para finalizar): ");
            int escolha = scanner.nextInt();
            
            if (escolha == 0) break;
            
            Prato prato = sistema.selecionarPrato(escolha);
            if (prato != null) {
                pedido.adicionarItem(prato);
                System.out.println("Item adicionado: " + prato.getDescricao());
            } else {
                System.out.println("Item não encontrado!");
            }
        }
        
        if (!pedido.getItensConsumidos().isEmpty()) {
            pedido.mostrarFatura();
            
            System.out.print("Valor recebido: R$ ");
            double valorRecebido = scanner.nextDouble();
            
            double troco = pedido.calcularTroco(valorRecebido);
            if (troco >= 0) {
                System.out.printf("Troco: R$ %.2f\n", troco);
            } else {
                System.out.printf("Valor insuficiente! Faltam R$ %.2f\n", Math.abs(troco));
            }
            
            sistema.adicionarPedido(pedido);
            System.out.println("Pedido finalizado com sucesso!");
        } else {
            System.out.println("Pedido vazio! Cancelando...");
        }
    }

    private static void testarFuncionalidades(SistemaLanchonete sistema) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           TESTE DE FUNCIONALIDADES");
        System.out.println("=".repeat(50));
        
        Pedido pedidoTeste = new Pedido("Cliente Teste", 0.1);
        
        Pizza pizza = new Pizza("Teste Pizza", 30.0, LocalDate.now().plusDays(7), 800.0, 
                               "Especial", "Premium", "Recheada");
        pedidoTeste.adicionarItem(pizza);
        
        Lanche lanche = new Lanche("Teste Lanche", 20.0, LocalDate.now().plusDays(3), 350.0, 
                                  "Artesanal", "Especial", "Barbecue");
        pedidoTeste.adicionarItem(lanche);
        
        Salgadinho salgadinho = new Salgadinho("Teste Salgadinho", 10.0, LocalDate.now().plusDays(2), 100.0, 
                                              TipoSalgadinho.ASSADO, "Integral", "Especial");
        pedidoTeste.adicionarItem(salgadinho);
        
        pedidoTeste.mostrarFatura();
        
        System.out.println("\nTeste de cálculo de troco:");
        System.out.printf("Valor recebido: R$ 100.00\n");
        System.out.printf("Troco: R$ %.2f\n", pedidoTeste.calcularTroco(100.0));
        
        System.out.println("\nTeste de produtos vencidos:");
        Prato produtoVencido = new Pizza("Pizza Vencida", 25.0, LocalDate.now().minusDays(1), 800.0, 
                                        "Tomate", "Mussarela", "Tradicional");
        System.out.println("Produto vencido: " + produtoVencido.estaVencido());
        
        sistema.adicionarPedido(pedidoTeste);
        System.out.println("\nTeste concluído com sucesso!");
    }
}

