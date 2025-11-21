package auxiliares;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorPiorCaso { // classe para gerar o arquivo de pior caso com 50.000 terrenos (gerada com IA)
    public static void main(String[] args) {
        String caminhoArquivo = "././entrada/terrenos_pior_caso.txt"; // caminho do arquivo de entrada (Caminho relativo ao src)
        int quantidade = 50000; // quantidade de terrenos a serem gerados

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) { // cria um BufferedWriter para escrever no arquivo
            writer.write(String.valueOf(quantidade)); // escreve a quantidade de terrenos na primeira linha
            writer.newLine(); // nova linha

            // dessa forma, o algoritmo de poda não consegue eliminar nenhum terreno, gerando o pior caso possível
            for (int i = 0; i < quantidade; i++) {
                int largura = i + 1;  // largura crescente de acordo com o i
                int comprimento = quantidade - i; // comprimento decrescente de acordo com o i

                writer.write(largura + " " + comprimento); // escreve a largura e o comprimento do terreno no arquivo (separados por espaço): "Largura Comprimento"
                writer.newLine(); // nova linha
            }

            System.out.println("Arquivo PIOR CASO gerado: " + caminhoArquivo); // mensagem de sucesso

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}