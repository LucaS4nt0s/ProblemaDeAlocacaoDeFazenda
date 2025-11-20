package principais;

public class Reta {
    private long m;
    private long c;

    public Reta(long m, long c) {
        this.m = m;
        this.c = c;
    }

    public long getY(int x) {
        return (m * x) + c;
    }

    public double intersecao(Reta outraReta) {
        return (double) (outraReta.c - this.c) / (this.m - outraReta.m);
    }
}
