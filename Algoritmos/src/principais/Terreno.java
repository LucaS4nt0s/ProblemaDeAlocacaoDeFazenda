package principais;

public final class Terreno {
    private int comprimento;
    private int largura;

    public Terreno(int largura, int comprimento) {
        try {
            this.setComprimento(comprimento);
            this.setLargura(largura);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getComprimento() {
        return comprimento;
    
    }

    public int getLargura() {
        return largura;
    }

    public void setComprimento(int comprimento) throws Exception {
        if (comprimento < 1) {
            throw new Exception("Comprimento deve ser maior ou igual a 1.");
        }

        if (comprimento > 1000000){
            throw new Exception("Comprimento deve ser menor ou igual a 1.000.000.");
        }
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) throws Exception {
        if (largura < 1) {
            throw new Exception("Largura deve ser maior ou igual a 1.");
        }

        if (largura > 1000000){
            throw new Exception("Largura deve ser menor ou igual a 1.000.000.");
        }
        this.largura = largura;
    }
}