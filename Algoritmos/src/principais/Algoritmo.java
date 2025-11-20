package principais;

import java.util.ArrayList;

public class Algoritmo {

    Terrenos terrenos;
    int custoMinimo;

    public Algoritmo() {
        this.terrenos = new Terrenos();
    }

    public ArrayList<Terreno> podarTerrenos(){
        ArrayList<Terreno> terrenosPodados = new ArrayList<>();
        int alturaMaximaVista = -1;


        for (int i = terrenos.getQuantidadeTerrenos()-1; i >= 0; i--) {
            Terreno terrenoAtual = terrenos.getListaTerrenos().get(i);

            if (terrenoAtual.getComprimento() > alturaMaximaVista) {
                Terreno terrenoPodado = new Terreno(terrenoAtual.getComprimento(), terrenoAtual.getLargura());
                terrenosPodados.add(terrenoPodado);
                alturaMaximaVista = terrenoAtual.getComprimento();
            }
        }

        return terrenosPodados;
    }

    public int custoMinimo(){
        custoMinimo = 0;

        return custoMinimo;
    }
}
