import java.util.HashSet;

public class exercicio14 {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();
        
        emails.add("joao@email.com");
        emails.add("maria@email.com");
        emails.add("pedro@email.com");
        emails.add("ana@email.com");
        
        System.out.println("E-mails adicionados: " + emails);
        System.out.println("Tamanho do HashSet: " + emails.size());
        
        boolean adicionado = emails.add("joao@email.com");
        System.out.println("Tentativa de adicionar duplicado 'joao@email.com': " + adicionado);
        
        System.out.println("E-mails após tentativa de duplicado: " + emails);
        System.out.println("Tamanho final do HashSet: " + emails.size());
    }
} 