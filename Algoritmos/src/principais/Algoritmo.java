package principais;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Collections;

public class Algoritmo {

    Terrenos terrenos; // cria um objeto da classe Terrenos para inicializar a lista de terrenos a partir do arquivo de entrada

    public Algoritmo() {
        this.terrenos = new Terrenos(); // inicializa o objeto Terrenos, que lê os terrenos do arquivo e os ordena
    }

    public ArrayList<Terreno> podarTerrenos(){ // classe para podar os terrenos "inuteis" (A lógica da poda funciona apenas com os terrenos ja ordenados, o que esta sendo feito em Terrenos)
        ArrayList<Terreno> terrenosPodados = new ArrayList<>();  // lista que armazenará os terrenos podados
        int alturaMaximaVista = -1; // variável para armazenar a maior altura vista até o momento

        for (int i = terrenos.getQuantidadeTerrenos()-1; i >= 0; i--) { // percorre a lista de terrenos de trás para frente
            Terreno terrenoAtual = terrenos.getListaTerrenos().get(i); // obtém o terreno atual

            if (terrenoAtual.getComprimento() > alturaMaximaVista) { // se o comprimento do terreno atual for maior que a altura máxima vista
                Terreno terrenoPodado = new Terreno(terrenoAtual.getLargura(), terrenoAtual.getComprimento()); // cria um novo terreno para adicionar à lista de terrenos podados
                terrenosPodados.add(terrenoPodado); // adiciona o terreno podado à lista
                alturaMaximaVista = terrenoAtual.getComprimento(); // atualiza a altura máxima vista
            }
        }

        Collections.reverse(terrenosPodados); // inverte a lista para manter a ordem original
        return terrenosPodados; // retorna a lista de terrenos podados
    }

    public long custoMinimo(){ // método para calcular o custo mínimo usando a técnica Convex Hull Trick (O método funciona apenas com os terrenos ordenados por largura crescente e comprimento decrescente)

        ArrayList<Terreno> terrenosPodados = podarTerrenos(); // obtém a lista de terrenos podados
        int m = terrenosPodados.size(); // armazena o tamanho da lista de terrenos podados

        ArrayList<Long> dp = new ArrayList<>(); // lista para armazenar os valores de custo mínimo
        for (int i = 0; i <= m; i++) { // inicializa a lista dp com zeros de 0 até m + 1
            dp.add(0L); // inicializa cada posição com 0L
        }

        Deque<Reta> dequeRetas = new java.util.ArrayDeque<>(); // cria uma fila de duas pontas para armazenar as retas
        Reta primeiraReta = new Reta(terrenosPodados.get(0).getComprimento(), 0); // cria a primeira reta com o comprimento do primeiro terreno podado e custo 0
        dequeRetas.addLast(primeiraReta); // adiciona a primeira reta à fila

        for (int i = 1; i <= m; i++) { // percorre os terrenos podados de 1 até m + 1
            int larguraAtual = terrenosPodados.get(i-1).getLargura(); // obtém a largura do terreno atual 

            while (dequeRetas.size() >= 2) { // enquanto houver pelo menos duas retas na fila
                Reta primeira = dequeRetas.pollFirst(); // remove e obtém a primeira reta da fila
                Reta segunda = dequeRetas.peekFirst(); // obtém a segunda reta da fila sem removê-la

                if (primeira.intersecao(segunda) <= larguraAtual) { // se a interseção da primeira e segunda reta for menor ou igual à largura atual
                    // descarta a primeira reta (ja feito anteriormente), pois a segunda é melhor para a largura atual
                } else { // se a interseção da primeira e segunda reta for maior que a largura atual
                    dequeRetas.addFirst(primeira); // recoloca a primeira reta na fila
                    break; // sai do loop, pois a primeira reta é a melhor para a largura atual
                }
            }

            Reta melhorReta = dequeRetas.getFirst(); // obtém a melhor reta (a primeira da fila)
            dp.set(i, melhorReta.getY(larguraAtual));  // calcula o custo mínimo para a largura atual usando a melhor reta

            if(i < m){ // se não for o último terreno podado
                int novo_m = terrenosPodados.get(i).getComprimento(); // obtém o comprimento do próximo terreno podado
                long novo_c = dp.get(i); // obtém o custo mínimo calculado até agora
                Reta novaReta = new Reta(novo_m, novo_c); // cria uma nova reta com o comprimento do próximo terreno podado e o custo mínimo atual

                while(dequeRetas.size() >= 2) { // enquanto houver pelo menos duas retas na fila
                    Reta ultima = dequeRetas.removeLast(); // remove e obtém a última reta da fila
                    Reta penultima = dequeRetas.getLast(); // obtém a penúltima reta da fila sem removê-la

                    double intercecao_nova = ultima.intersecao(novaReta); // calcula a interseção entre a última reta e a nova reta
                    double intercecao_velha = penultima.intersecao(ultima); // calcula a interseção entre a penúltima e a última reta
                    
                    if(intercecao_nova <= intercecao_velha) { // se a interseção da nova reta com a última for menor ou igual à interseção da penúltima com a última
                        // descarta a última reta (ja feito anteriormente), pois a nova reta é melhor
                    } else { // se a interseção da nova reta com a última for maior que a interseção da penúltima com a última
                        dequeRetas.addLast(ultima); // recoloca a última reta na fila
                        break; // sai do loop, pois a última reta é melhor que a nova
                    }
                }

                dequeRetas.addLast(novaReta); // adiciona a nova reta à fila
            }
        }
        return dp.get(m); // retorna o custo mínimo para todos os terrenos podados
    }
}
