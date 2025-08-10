import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Produto {
    private int codigo;
    public String nome;
    protected double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    private double calcularImposto() {
        return preco * 0.1;
    }
}

public class AnalisadorDeClasse {
    public static void inspecionar(Object obj) {
        Class<?> classe = obj.getClass();
        
        System.out.println("Nome completo da classe: " + classe.getName());
        
        System.out.println("\nAtributos:");
        Field[] campos = classe.getDeclaredFields();
        for (Field campo : campos) {
            System.out.println("  " + campo.getModifiers() + " " + campo.getType().getSimpleName() + " " + campo.getName());
        }
        
        System.out.println("\nMétodos:");
        Method[] metodos = classe.getDeclaredMethods();
        for (Method metodo : metodos) {
            System.out.println("  " + metodo.getModifiers() + " " + metodo.getReturnType().getSimpleName() + " " + metodo.getName() + "()");
        }
    }
}

public class exercicio31 {
    public static void main(String[] args) {
        Produto p = new Produto(101, "Notebook Gamer", 8500.0);
        AnalisadorDeClasse.inspecionar(p);
    }
} 