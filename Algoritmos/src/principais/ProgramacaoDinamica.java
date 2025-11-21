package principais;

import java.util.ArrayList;

public class ProgramacaoDinamica {
    
    Algoritmo algoritmo;
    public ProgramacaoDinamica() {
        this.algoritmo = new Algoritmo();
    }

    public long custoMinimo() {
        ArrayList<Terreno> terrenosPodados = this.algoritmo.podarTerrenos();
        int m = terrenosPodados.size();

        long[] dp = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                long custo = dp[j] + (long) terrenosPodados.get(i-1).getLargura() * terrenosPodados.get(j).getComprimento(); 
                if (custo < dp[i]) dp[i] = custo;
            }
        }
        return dp[m];
    }
}
