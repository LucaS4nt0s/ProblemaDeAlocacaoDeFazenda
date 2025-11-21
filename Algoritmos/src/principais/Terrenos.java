package principais;

import java.util.ArrayList;
import auxiliares.FileManager;

public final class Terrenos { // classe para representar uma coleção de terrenos
    private final ArrayList<Terreno> listaTerrenos; // lista para armazenar os terrenos
    private int quantidadeTerrenos; // quantidade de terrenos na coleção
    private final String path = "././entrada/terrenos_pior_caso.txt"; // caminho do arquivo de entrada (Caminho relativo ao src)

    public Terrenos() { // construtor da classe Terrenos
        this.listaTerrenos = new ArrayList<>(); // inicializa a lista de terrenos
        FileManager fileManager = new FileManager(); // cria um objeto FileManager para ler o arquivo de entrada
        ArrayList<String> linhas = fileManager.stringReader(this.path); // lê as linhas do arquivo de entrada (Caminho relativo ao src)

        try {
            setQuantidadeTerrenos(Integer.parseInt(linhas.get(0))); // define a quantidade de terrenos a partir da primeira linha do arquivo
        } catch (Exception e) {
            System.out.println(e.getMessage()); // exibe a mensagem de erro caso a quantidade de terrenos seja inválida
        }
        
        for (int i = 1; i <= this.quantidadeTerrenos; i++) { // percorre as linhas do arquivo para ler os terrenos
            String[] partes = linhas.get(i).trim().split(" "); // divide a linha em largura e comprimento
            int largura = Integer.parseInt(partes[0]); // obtém a largura do terreno
            int comprimento = Integer.parseInt(partes[1]); // obtém o comprimento do terreno
            Terreno terreno = new Terreno(largura, comprimento); // cria um novo objeto Terreno
            this.listaTerrenos.add(terreno); // adiciona o terreno à lista
        } 

        ordenarTerrenosPorLargura(); // ordena os terrenos por largura crescente e comprimento decrescente
    }

    public void ordenarTerrenosPorLargura() {
        // ordena a lista de terrenos pela largura (e comprimento em caso de empate) em ordem crescente
        this.listaTerrenos.sort((t1, t2) -> Integer.compare(t1.getLargura(), t2.getLargura()) != 0 ? Integer.compare(t1.getLargura(), t2.getLargura()) : Integer.compare(t1.getComprimento(), t2.getComprimento()));
    }

    public ArrayList<Terreno> getListaTerrenos() {
        return listaTerrenos; // retorna a lista de terrenos
    }

    public int getQuantidadeTerrenos() {
        return quantidadeTerrenos; // retorna a quantidade de terrenos
    }

    private void setQuantidadeTerrenos(int quantidadeTerrenos) throws Exception { // define a quantidade de terrenos com validação (usada no construtor)
        if (quantidadeTerrenos < 1) {
            throw new Exception("Quantidade de terrenos deve ser maior ou igual a 1.");
        }
        if (quantidadeTerrenos > 50000) {
            throw new Exception("Quantidade de terrenos deve ser menor ou igual a 50.000.");
        }

        this.quantidadeTerrenos = quantidadeTerrenos;
    }

}
