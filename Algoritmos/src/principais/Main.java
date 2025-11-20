package principais;

public class Main {
    public static void main(String[] args) {
        Algoritmo algoritmo = new Algoritmo();

        for (Terreno terreno : algoritmo.podarTerrenos()) {
            System.out.println(terreno.getComprimento() + " " + terreno.getLargura());
        }
    }
}
