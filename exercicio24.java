import java.util.LinkedList;
import java.util.Queue;

public class exercicio24 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();
        
        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Foto.png");
        filaImpressao.add("Relatorio.docx");
        filaImpressao.add("Apresentacao.pptx");
        filaImpressao.add("Planilha.xlsx");
        
        System.out.println("Fila de impressão inicial: " + filaImpressao);
        System.out.println("Processando documentos...");
        
        while (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll();
            System.out.println("Imprimindo: " + documento);
        }
        
        System.out.println("Todos os documentos foram impressos!");
    }
} 