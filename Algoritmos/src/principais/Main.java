package principais;

public class Main {
    public static void main(String[] args) {
        Algoritmo algoritmo = new Algoritmo();

        for (Terreno terreno : algoritmo.podarTerrenos()) {
            System.out.println(terreno.getComprimento() + " " + terreno.getLargura());
            
        }
        System.out.println("Custo mínimo Convex Hull Trick: " + algoritmo.custoMinimo());

        ProgramacaoDinamica pd = new ProgramacaoDinamica();
        System.out.println("Custo mínimo Programação Dinâmica: " + pd.custoMinimo());
    }
}
