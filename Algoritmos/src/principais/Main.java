package principais;

public class Main {
    public static void main(String[] args) {
        Algoritmo algoritmo = new Algoritmo(); // cria um objeto da classe Algoritmo para usar a solução Convex Hull Trick
        System.out.println("Custo mínimo Convex Hull Trick: " + algoritmo.custoMinimo()); // exibe o custo mínimo calculado pela técnica Convex Hull Trick (O(N log N), determinado pela ordenação dos terrenos)

        ProgramacaoDinamica pd = new ProgramacaoDinamica(); // cria um objeto da classe ProgramacaoDinamica para usar a solução O(N^2)
        System.out.println("Custo mínimo Programação Dinâmica: " + pd.custoMinimo()); // exibe o custo mínimo calculado pela solução O(N^2)
    }
}
