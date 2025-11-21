package principais;

import java.util.ArrayList;
import auxiliares.FileManager;

public final class Terrenos {
    private final ArrayList<Terreno> listaTerrenos;
    private int quantidadeTerrenos;

    public Terrenos() {
        this.listaTerrenos = new ArrayList<>();
        FileManager fileManager = new FileManager();
        ArrayList<String> linhas = fileManager.stringReader("././entrada/terrenos_50k.txt");

        try {
            setQuantidadeTerrenos(Integer.parseInt(linhas.get(0)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        for (int i = 1; i <= this.quantidadeTerrenos; i++) {
            String[] partes = linhas.get(i).trim().split(" ");
            int largura = Integer.parseInt(partes[0]);
            int comprimento = Integer.parseInt(partes[1]);
            Terreno terreno = new Terreno(largura, comprimento);
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

    public void setQuantidadeTerrenos(int quantidadeTerrenos) throws Exception {
        if (quantidadeTerrenos < 1) {
            throw new Exception("Quantidade de terrenos deve ser maior ou igual a 1.");
        }
        if (quantidadeTerrenos > 50000) {
            throw new Exception("Quantidade de terrenos deve ser menor ou igual a 50.000.");
        }

        this.quantidadeTerrenos = quantidadeTerrenos;
    }

}
