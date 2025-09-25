package ExercicioImagem;

public class Cantor {

    private String nome;
    private int idade;
    private String país;

    public Cantor(String nome, int idade, String país) {
        this.nome = nome;
        this.idade = idade;
        this.país = país;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public void exibir(){
        System.out.println("O " +nome+ " tem " +  idade + " anos" );
    }
}


