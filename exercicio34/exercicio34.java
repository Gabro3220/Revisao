package exercicio34;
import java.util.*;
import java.time.LocalDate;

@interface Teste {
}

enum TipoCliente {
    PESSOA_FISICA, PESSOA_JURIDICA
}

enum TipoConta {
    CORRENTE, CDI, INVESTIMENTO_AUTOMATICO
}

enum TipoProduto {
    RENDA_FIXA, RENDA_VARIAVEL
}

abstract class Cliente {
    protected String nome;
    protected String email;
    protected List<Conta> contas;
    protected TipoCliente tipo;

    public Cliente(String nome, String email, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.contas = new ArrayList<>();
    }

    public abstract String getDocumento();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

abstract class Conta {
    protected String numero;
    protected double saldo;
    protected TipoConta tipo;
    protected Cliente proprietario;

    public Conta(String numero, double saldo, TipoConta tipo, Cliente proprietario) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
        this.proprietario = proprietario;
    }

    public abstract double calcularRendimento(int dias);
    public abstract double calcularTaxaServico(double rendimento);

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

abstract class ProdutoInvestimento {
    protected String nome;
    protected String descricao;
    protected double rendimentoMensal;
    protected TipoProduto tipo;

    public ProdutoInvestimento(String nome, String descricao, double rendimentoMensal, TipoProduto tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.rendimentoMensal = rendimentoMensal;
        this.tipo = tipo;
    }

    public abstract double calcularRendimento(double valor, int dias);

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
}

class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String email, String cpf) {
        super(nome, email, TipoCliente.PESSOA_FISICA);
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String cnpj) {
        super(nome, email, TipoCliente.PESSOA_JURIDICA);
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

class ContaCorrente extends Conta {
    public ContaCorrente(String numero, double saldo, Cliente proprietario) {
        super(numero, saldo, TipoConta.CORRENTE, proprietario);
    }

    @Override
    public double calcularRendimento(int dias) {
        return 0.0;
    }

    @Override
    public double calcularTaxaServico(double rendimento) {
        return 0.0;
    }
}

class ContaCDI extends Conta {
    private static final double TAXA_CDI_DIARIA = 0.01 / 30; 
    private static final double TAXA_SERVICO = 0.0007; 

    public ContaCDI(String numero, double saldo, Cliente proprietario) {
        super(numero, saldo, TipoConta.CDI, proprietario);
    }

    @Override
    public double calcularRendimento(int dias) {
        return saldo * TAXA_CDI_DIARIA * dias;
    }

    @Override
    public double calcularTaxaServico(double rendimento) {
        return rendimento * TAXA_SERVICO;
    }
}

class ContaInvestimentoAutomatico extends Conta {
    private static final double TAXA_SERVICO_PF = 0.001; 
    private static final double TAXA_SERVICO_PJ = 0.0015; 

    public ContaInvestimentoAutomatico(String numero, double saldo, Cliente proprietario) {
        super(numero, saldo, TipoConta.INVESTIMENTO_AUTOMATICO, proprietario);
    }

    @Override
    public double calcularRendimento(int dias) {

        return saldo * (0.008 / 30) * dias;
    }

    @Override
    public double calcularTaxaServico(double rendimento) {
        if (proprietario.getTipo() == TipoCliente.PESSOA_FISICA) {
            return rendimento * TAXA_SERVICO_PF;
        } else {
            return rendimento * TAXA_SERVICO_PJ;
        }
    }
}

class ProdutoRendaFixa extends ProdutoInvestimento {
    private int periodoCarencia; 

    public ProdutoRendaFixa(String nome, String descricao, double rendimentoMensal, int periodoCarencia) {
        super(nome, descricao, rendimentoMensal, TipoProduto.RENDA_FIXA);
        this.periodoCarencia = periodoCarencia;
    }

    @Override
    public double calcularRendimento(double valor, int dias) {
        if (dias < periodoCarencia) {
            return 0.0;
        }
        return valor * (rendimentoMensal / 30) * dias;
    }

    public int getPeriodoCarencia() {
        return periodoCarencia;
    }

    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }
}

class ProdutoRendaVariavel extends ProdutoInvestimento {
    public ProdutoRendaVariavel(String nome, String descricao, double rendimentoMensal) {
        super(nome, descricao, rendimentoMensal, TipoProduto.RENDA_VARIAVEL);
    }

    @Override
    public double calcularRendimento(double valor, int dias) {
        return valor * (rendimentoMensal / 30) * dias;
    }
}

class SistemaVcRiquinho {
    private List<Cliente> clientes;
    private List<ProdutoInvestimento> produtos;

    public SistemaVcRiquinho() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
    }

    public Cliente buscarCliente(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    public void atualizarCliente(String documento, String novoNome, String novoEmail) {
        Cliente cliente = buscarCliente(documento);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setEmail(novoEmail);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void removerCliente(String documento) {
        Cliente cliente = buscarCliente(documento);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println("Tipo: " + cliente.getTipo());
            System.out.println("Número de contas: " + cliente.getContas().size());
            System.out.println("---");
        }
    }

    public void adicionarProduto(ProdutoInvestimento produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado com sucesso!");
    }

    public ProdutoInvestimento buscarProduto(String nome) {
        for (ProdutoInvestimento produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarProduto(String nome, String novaDescricao, double novoRendimento) {
        ProdutoInvestimento produto = buscarProduto(nome);
        if (produto != null) {
            produto.setDescricao(novaDescricao);
            produto.setRendimentoMensal(novoRendimento);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void removerProduto(String nome) {
        ProdutoInvestimento produto = buscarProduto(nome);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        for (ProdutoInvestimento produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Rendimento Mensal: " + produto.getRendimentoMensal() + "%");
            System.out.println("Tipo: " + produto.getTipo());
            if (produto instanceof ProdutoRendaFixa) {
                System.out.println("Carência: " + ((ProdutoRendaFixa) produto).getPeriodoCarencia() + " dias");
            }
            System.out.println("---");
        }
    }

    public void simularRendimento(String documentoCliente, int dias) {
        Cliente cliente = buscarCliente(documentoCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("\n=== SIMULAÇÃO DE RENDIMENTO ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Período: " + dias + " dias");
        System.out.println("---");

        double rendimentoTotal = 0.0;
        double taxaServicoTotal = 0.0;

        for (Conta conta : cliente.getContas()) {
            double rendimento = conta.calcularRendimento(dias);
            double taxaServico = conta.calcularTaxaServico(rendimento);

            System.out.println("Conta " + conta.getNumero() + " (" + conta.getTipo() + "):");
            System.out.println("  Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            System.out.println("  Rendimento: R$ " + String.format("%.2f", rendimento));
            System.out.println("  Taxa de Serviço: R$ " + String.format("%.2f", taxaServico));
            System.out.println("  Rendimento Líquido: R$ " + String.format("%.2f", rendimento - taxaServico));

            rendimentoTotal += rendimento;
            taxaServicoTotal += taxaServico;
        }

        System.out.println("\n=== RESUMO ===");
        System.out.println("Rendimento Total: R$ " + String.format("%.2f", rendimentoTotal));
        System.out.println("Taxa de Serviço Total: R$ " + String.format("%.2f", taxaServicoTotal));
        System.out.println("Rendimento Líquido Total: R$ " + String.format("%.2f", rendimentoTotal - taxaServicoTotal));
    }
}

public class exercicio34 {
    public static void main(String[] args) {
        SistemaVcRiquinho sistema = new SistemaVcRiquinho();

        PessoaFisica pf1 = new PessoaFisica("João Silva", "joao@email.com", "123.456.789-00");
        PessoaJuridica pj1 = new PessoaJuridica("Empresa ABC", "contato@abc.com", "12.345.678/0001-90");

        ContaCorrente cc1 = new ContaCorrente("CC001", 5000.0, pf1);
        ContaCDI cd1 = new ContaCDI("CDI001", 10000.0, pf1);
        ContaInvestimentoAutomatico cia1 = new ContaInvestimentoAutomatico("CIA001", 15000.0, pj1);

        pf1.adicionarConta(cc1);
        pf1.adicionarConta(cd1);
        pj1.adicionarConta(cia1);

        ProdutoRendaFixa prf1 = new ProdutoRendaFixa("CDB Banco XYZ", "CDB com rendimento fixo", 0.8, 30);
        ProdutoRendaFixa prf2 = new ProdutoRendaFixa("LCI Banco ABC", "LCI com carência de 90 dias", 0.9, 90);
        ProdutoRendaVariavel prv1 = new ProdutoRendaVariavel("Ações Petrobras", "Carteira de ações da Petrobras", 1.2);

        sistema.adicionarCliente(pf1);
        sistema.adicionarCliente(pj1);
        sistema.adicionarProduto(prf1);
        sistema.adicionarProduto(prf2);
        sistema.adicionarProduto(prv1);

        System.out.println("=== SISTEMA VCRIQUINHO ===");
        
        sistema.listarClientes();
        sistema.listarProdutos();

        sistema.simularRendimento("123.456.789-00", 30);
        sistema.simularRendimento("123.456.789-00", 90);
        sistema.simularRendimento("12.345.678/0001-90", 60);

        System.out.println("\n=== TESTANDO OPERAÇÕES CRUD ===");
        sistema.atualizarCliente("123.456.789-00", "João Silva Santos", "joao.santos@email.com");
        sistema.atualizarProduto("CDB Banco XYZ", "CDB com rendimento fixo atualizado", 0.85);
        
        sistema.listarClientes();
        sistema.listarProdutos();
    }
}

