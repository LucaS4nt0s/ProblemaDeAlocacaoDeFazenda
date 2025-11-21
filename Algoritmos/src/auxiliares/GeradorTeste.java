package auxiliares;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorTeste { // classe para gerar o arquivo de testes com 50.000 terrenos aleatórios

    public static void main(String[] args) {
        // Configurações
        String caminhoArquivo = "././entrada/terrenos.txt"; // gera o arquivo de entrada (Caminho relativo ao src)
        int quantidadeTerrenos = 50000; // Quantidade de terrenos a serem gerados
        int valorMaximoDimensao = 1000000; // Dimensão máxima de cada terreno (largura e comprimento)

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) { // cria um BufferedWriter para escrever no arquivo
            
            writer.write(String.valueOf(quantidadeTerrenos)); // escreve a quantidade de terrenos na primeira linha
            writer.newLine(); // nova linha

            Random random = new Random(); // cria um objeto Random para gerar números aleatórios

            for (int i = 0; i < quantidadeTerrenos; i++) { // gera cada terreno com largura e comprimento aleatórios dentro do limite especificado em quantidadeTerrenos
                int largura = random.nextInt(valorMaximoDimensao) + 1; // largura aleatória entre 1 e valorMaximoDimensao
                int comprimento = random.nextInt(valorMaximoDimensao) + 1; // comprimento aleatório entre 1 e valorMaximoDimensao

                writer.write(largura + " " + comprimento); // escreve a largura e o comprimento do terreno no arquivo (separados por espaço): "Largura Comprimento"
                writer.newLine(); // nova linha
            }

            System.out.println("Arquivo gerado com sucesso em: " + caminhoArquivo); // mensagem de sucesso
            System.out.println("Quantidade: " + quantidadeTerrenos); // exibe a quantidade de terrenos gerados

        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage()); // mensagem de erro em caso de falha na escrita do arquivo
        }
    }
}