public class Main {
    public static void main(String[] args) {
        // Criando objetos
        Pessoa p1 = new Pessoa("João", 25, "Joca");
        Comida c1 = new Comida("Pizza", "Italiana", "R$ 40,00");
        Cidade cid1 = new Cidade("São Paulo", "12 milhões", "João");

        // Chamando métodos
        p1.apresentar();
        c1.serIngerido();
        cid1.viajar();
    }
}
