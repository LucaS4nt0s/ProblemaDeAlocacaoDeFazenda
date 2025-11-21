package auxiliares;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorTeste { // classe gerada com IA apenas para gerar o arquivo de testes com 50.000 terrenos aleatórios

    public static void main(String[] args) {
        // Configurações
        String caminhoArquivo = "././entrada/terrenos_50k.txt"; // Ajuste o caminho se necessário
        int quantidadeTerrenos = 50000; // N máximo do problema
        int valorMaximoDimensao = 1000000; // Dimensão máxima segundo o PDF

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            
            // 1. Escreve a primeira linha (N)
            writer.write(String.valueOf(quantidadeTerrenos));
            writer.newLine();

            Random random = new Random();

            // 2. Gera as 50.000 linhas com valores aleatórios
            for (int i = 0; i < quantidadeTerrenos; i++) {
                // random.nextInt(max) gera de 0 a max-1. Somamos 1 para ser de 1 a max.
                int largura = random.nextInt(valorMaximoDimensao) + 1;
                int comprimento = random.nextInt(valorMaximoDimensao) + 1;

                writer.write(largura + " " + comprimento);
                writer.newLine();
            }

            System.out.println("Arquivo gerado com sucesso em: " + caminhoArquivo);
            System.out.println("Quantidade: " + quantidadeTerrenos);

        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}