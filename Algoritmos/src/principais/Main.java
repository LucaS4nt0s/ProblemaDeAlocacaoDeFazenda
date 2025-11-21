package principais;


public class Main {
    public static void main(String[] args) {
        long startTimeCHT, endTimeCHT; // temporizadores para medir o tempo de execução da solução Convex Hull Trick
        startTimeCHT = System.currentTimeMillis(); // inicia o temporizador
        Algoritmo algoritmo = new Algoritmo(); // cria um objeto da classe Algoritmo para usar a solução Convex Hull Trick
        System.out.println("Custo mínimo Convex Hull Trick: " + algoritmo.custoMinimo()); // exibe o custo mínimo calculado pela técnica Convex Hull Trick (O(N log N), determinado pela ordenação dos terrenos)
        endTimeCHT = System.currentTimeMillis(); // finaliza o temporizador
        System.out.println("Tempo de execução Convex Hull Trick: " + (endTimeCHT - startTimeCHT) + " ms"); // exibe o tempo de execução da técnica Convex Hull Trick

        long startTimeDP, endTimeDP; // temporizadores para medir o tempo de execução da solução O(N^2) usando programação dinâmica
        startTimeDP = System.currentTimeMillis(); // inicia o temporizador
        ProgramacaoDinamica pd = new ProgramacaoDinamica(); // cria um objeto da classe ProgramacaoDinamica para usar a solução O(N^2)
        System.out.println("Custo mínimo Programação Dinâmica: " + pd.custoMinimo()); // exibe o custo mínimo calculado pela solução O(N^2)
        endTimeDP = System.currentTimeMillis(); // finaliza o temporizador
        System.out.println("Tempo de execução Programação Dinâmica: " + (endTimeDP - startTimeDP) + " ms"); // exibe o tempo de execução da solução O(N^2) usando programação dinâmica 
    }
}
