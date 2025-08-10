import java.util.LinkedHashMap;

public class exercicio21 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> produtos = new LinkedHashMap<>();
        
        produtos.put(1001, "Notebook");
        produtos.put(1002, "Mouse");
        produtos.put(1003, "Teclado");
        produtos.put(1004, "Monitor");
        produtos.put(1005, "Headset");
        
        System.out.println("Produtos na ordem de cadastro:");
        for (Integer codigo : produtos.keySet()) {
            System.out.println("Código: " + codigo + " - Produto: " + produtos.get(codigo));
        }
    }
} 