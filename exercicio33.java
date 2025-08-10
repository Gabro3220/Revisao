import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Teste {
}

public class MinhaClasseDeTeste {
    @Teste
    public void testeSoma() {
        System.out.println("Executando testeSoma: SUCESSO");
    }

    public void metodoComum() {
        System.out.println("Este não é um teste.");
    }

    @Teste
    public void testeLogin() {
        System.out.println("Executando testeLogin: SUCESSO");
    }
}

public class ExecutorDeTestes {
    public static void executarTestes(Object obj) throws Exception {
        Class<?> classe = obj.getClass();
        Method[] metodos = classe.getDeclaredMethods();
        
        System.out.println("Executando testes da classe: " + classe.getSimpleName());
        
        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(Teste.class)) {
                metodo.invoke(obj);
            }
        }
    }
}

public class exercicio33 {
    public static void main(String[] args) throws Exception {
        MinhaClasseDeTeste objetoTeste = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(objetoTeste);
    }
} 