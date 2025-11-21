package principais;

public class Reta { // classe para representar uma reta na forma y = mx + c (m = coeficiente angular, c = coeficiente linear) (para uso na técnica Convex Hull Trick)
    private final long m; // coeficiente angular
    private final long c; // coeficiente linear

    public Reta(long m, long c) { // construtor da classe Reta
        this.m = m; // inicializa o coeficiente angular
        this.c = c; // inicializa o coeficiente linear
    }

    public long getY(int x) {
        return (m * x) + c; // calcula o valor de y para um dado x na reta
    }

    public double intersecao(Reta outraReta) {
        return (double) (outraReta.c - this.c) / (this.m - outraReta.m); // calcula o ponto de interseção entre duas retas
    }
}
