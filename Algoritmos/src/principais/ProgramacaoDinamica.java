package principais;

import java.util.ArrayList;

public class ProgramacaoDinamica { // implementação da solução de Programação Dinâmica (O(N^2)) para fins de comparação com a solução Convex Hull Trick
    
    Algoritmo algoritmo; // cria um objeto da classe Algoritmo para reutilizar o método de poda de terrenos
    public ProgramacaoDinamica() {  
        this.algoritmo = new Algoritmo(); // inicializa o objeto Algoritmo
    }

    public long custoMinimo() { // método para calcular o custo mínimo usando Programação Dinâmica O(N^2)
        ArrayList<Terreno> terrenosPodados = this.algoritmo.podarTerrenos(); // obtém a lista de terrenos podados usando o método de poda da classe Algoritmo
        int m = terrenosPodados.size(); // armazena o tamanho da lista de terrenos podados

        long[] dp = new long[m + 1]; // array para armazenar os valores de custo mínimo
        for (int i = 1; i <= m; i++) { // itera sobre os terrenos podados para calcular o custo mínimo
            dp[i] = Long.MAX_VALUE; // inicializa o custo mínimo como infinito
            for (int j = 0; j < i; j++) { // itera sobre os terrenos anteriores para calcular o custo mínimo
                long custo = dp[j] + (long) terrenosPodados.get(i-1).getLargura() * terrenosPodados.get(j).getComprimento(); // calcula o custo para a combinação atual
                if (custo < dp[i]) {
                    dp[i] = custo; // atualiza o custo mínimo se o custo calculado for menor
                }
            }
        }
        return dp[m]; // retorna o custo mínimo para todos os terrenos podados
    }
}
