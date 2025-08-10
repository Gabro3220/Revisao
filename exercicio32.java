import java.lang.reflect.Field;

public class Configuracao {
    private String urlConexao = "localhost:5432";
}

public class exercicio32 {
    public static void main(String[] args) throws Exception {
        Configuracao config = new Configuracao();
        
        Field campo = Configuracao.class.getDeclaredField("urlConexao");
        campo.setAccessible(true);
        
        System.out.println("Valor original: " + campo.get(config));
        
        campo.set(config, "db.producao.com:5432");
        
        System.out.println("Valor modificado: " + campo.get(config));
    }
} 