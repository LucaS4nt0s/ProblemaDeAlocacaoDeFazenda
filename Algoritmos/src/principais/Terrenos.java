package principais;

import java.util.ArrayList;
import auxiliares.FileManager;

public final class Terrenos {
    private final ArrayList<Terreno> listaTerrenos;
    private final int quantidadeTerrenos;

    public Terrenos() {
        this.listaTerrenos = new ArrayList<>();
        FileManager fileManager = new FileManager();
        ArrayList<String> linhas = fileManager.stringReader("././entrada/terrenos.txt");

        this.quantidadeTerrenos = Integer.parseInt(linhas.get(0));

        for (int i = 1; i <= this.quantidadeTerrenos; i++) {
            String[] partes = linhas.get(i).trim().split(" ");
            int comprimento = Integer.parseInt(partes[0]);
            int largura = Integer.parseInt(partes[1]);
            Terreno terreno = new Terreno(comprimento, largura);
            this.listaTerrenos.add(terreno);
        } 

        ordenarTerrenosPorLargura();
    }

    public void ordenarTerrenosPorLargura() {
        // ordena a lista de terrenos pela largura (e comprimento em caso de empate) em ordem crescente
        this.listaTerrenos.sort((t1, t2) -> Integer.compare(t1.getLargura(), t2.getLargura()) != 0 ? Integer.compare(t1.getLargura(), t2.getLargura()) : Integer.compare(t1.getComprimento(), t2.getComprimento()));
    }

    public ArrayList<Terreno> getListaTerrenos() {
        return listaTerrenos;
    }

    public int getQuantidadeTerrenos() {
        return quantidadeTerrenos;
    }

}
