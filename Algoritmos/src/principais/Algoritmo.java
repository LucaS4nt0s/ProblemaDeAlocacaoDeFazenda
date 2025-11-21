package principais;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Collections;

public class Algoritmo {

    Terrenos terrenos;

    public Algoritmo() {
        this.terrenos = new Terrenos();
    }

    public ArrayList<Terreno> podarTerrenos(){
        ArrayList<Terreno> terrenosPodados = new ArrayList<>();
        int alturaMaximaVista = -1;


        for (int i = terrenos.getQuantidadeTerrenos()-1; i >= 0; i--) {
            Terreno terrenoAtual = terrenos.getListaTerrenos().get(i);

            if (terrenoAtual.getComprimento() > alturaMaximaVista) {
                Terreno terrenoPodado = new Terreno(terrenoAtual.getLargura(), terrenoAtual.getComprimento());
                terrenosPodados.add(terrenoPodado);
                alturaMaximaVista = terrenoAtual.getComprimento();
            }
        }

        Collections.reverse(terrenosPodados);
        return terrenosPodados;
    }

    public long custoMinimo(){

        ArrayList<Terreno> terrenosPodados = podarTerrenos();
        int m = terrenosPodados.size();

        ArrayList<Long> dp = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            dp.add(0L);
        }

        Deque<Reta> dequeRetas = new java.util.ArrayDeque<>();
        Reta primeiraReta = new Reta(terrenosPodados.get(0).getComprimento(), 0);
        dequeRetas.addLast(primeiraReta);

        for (int i = 1; i <= m; i++) {
            int larguraAtual = terrenosPodados.get(i-1).getLargura();

            while (dequeRetas.size() >= 2) {
                Reta primeira = dequeRetas.pollFirst(); 
                Reta segunda = dequeRetas.peekFirst(); 

                if (primeira.intersecao(segunda) <= larguraAtual) {
                    continue; 
                } else {
                    dequeRetas.addFirst(primeira);
                    break; 
                }
            }

            Reta melhorReta = dequeRetas.getFirst();
            dp.set(i, melhorReta.getY(larguraAtual));   

            if(i < m){
                int novo_m = terrenosPodados.get(i).getComprimento();
                long novo_c = dp.get(i);
                Reta novaReta = new Reta(novo_m, novo_c);

                while(dequeRetas.size() >= 2) {
                    Reta ultima = dequeRetas.removeLast();
                    Reta penultima = dequeRetas.getLast();

                    double intercecao_nova = ultima.intersecao(novaReta);
                    double intercecao_velha = penultima.intersecao(ultima); 
                    
                    if(intercecao_nova <= intercecao_velha) {
                        continue;
                    } else {
                        dequeRetas.addLast(ultima);
                        break;
                    }
                }

                dequeRetas.addLast(novaReta);
            }
        }
        return dp.get(m);
    }
}
