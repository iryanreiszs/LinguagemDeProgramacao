public class Comida {
    private String nome;
    private String tipo;
    private String preco;

    public Comida(String nome, String tipo, String preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public void serIngerido() {
        System.out.println(nome + " está sendo ingerido.");
    }
}
