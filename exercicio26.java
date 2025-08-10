import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}

public class exercicio26 {
    public static void main(String[] args) {
        Map<String, List<Produto>> catalogo = new HashMap<>();
        
        List<Produto> eletronicos = new ArrayList<>();
        eletronicos.add(new Produto("Notebook", 2500.0));
        eletronicos.add(new Produto("Smartphone", 1200.0));
        eletronicos.add(new Produto("Tablet", 800.0));
        
        List<Produto> livros = new ArrayList<>();
        livros.add(new Produto("Dom Casmurro", 25.0));
        livros.add(new Produto("O Cortiço", 30.0));
        livros.add(new Produto("Grande Sertão", 45.0));
        
        List<Produto> roupas = new ArrayList<>();
        roupas.add(new Produto("Camiseta", 50.0));
        roupas.add(new Produto("Calça Jeans", 120.0));
        roupas.add(new Produto("Tênis", 200.0));
        
        catalogo.put("Eletrônicos", eletronicos);
        catalogo.put("Livros", livros);
        catalogo.put("Roupas", roupas);
        
        String categoria = "Eletrônicos";
        System.out.println("Produtos da categoria '" + categoria + "':");
        List<Produto> produtosCategoria = catalogo.get(categoria);
        for (Produto produto : produtosCategoria) {
            System.out.println(produto);
        }
    }
} 