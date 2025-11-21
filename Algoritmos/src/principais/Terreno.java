package principais;

public final class Terreno { // classe para representar um terreno com largura e comprimento
    private int comprimento; // comprimento do terreno
    private int largura; // largura do terreno

    public Terreno(int largura, int comprimento) { // construtor da classe Terreno
        try {
            this.setComprimento(comprimento); // define o comprimento do terreno com validação (pode gerar exceção caso o comprimento não esteja entre 1 e 1.000.000)
            this.setLargura(largura); // define a largura do terreno com validação (pode gerar exceção caso a largura não esteja entre 1 e 1.000.000)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getComprimento() {
        return comprimento; // retorna o comprimento do terreno
    }

    public int getLargura() {
        return largura; // retorna a largura do terreno
    }

    private void setComprimento(int comprimento) throws Exception { // define o comprimento do terreno com validação (pode gerar exceção caso o comprimento não esteja entre 1 e 1.000.000) (usado no construtor)
        if (comprimento < 1) {
            throw new Exception("Comprimento deve ser maior ou igual a 1.");
        }

        if (comprimento > 1000000){
            throw new Exception("Comprimento deve ser menor ou igual a 1.000.000.");
        }
        this.comprimento = comprimento;
    }

    private void setLargura(int largura) throws Exception { // define a largura do terreno com validação (pode gerar exceção caso a largura não esteja entre 1 e 1.000.000) (usado no construtor)
        if (largura < 1) {
            throw new Exception("Largura deve ser maior ou igual a 1.");
        }

        if (largura > 1000000){
            throw new Exception("Largura deve ser menor ou igual a 1.000.000.");
        }
        this.largura = largura;
    }
}