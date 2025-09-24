public class Comida {
    private String nome;
    private String tipo;
    private int preco;

    public Comida(String nome, String tipo, int preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void serIngerido() {
        System.out.println(nome + " está sendo ingerido.");
    }
}
