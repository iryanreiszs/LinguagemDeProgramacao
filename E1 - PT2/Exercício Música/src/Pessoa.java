public class Pessoa {

    private String nome;
    private int idade;
    private String apelido;

    public Pessoa(String nome, int idade, String apelido) {
        this.nome = nome;
        this.idade = idade;
        this.apelido = apelido;
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " (" + apelido + "), e tenho " + idade + " anos.");
    }

}
