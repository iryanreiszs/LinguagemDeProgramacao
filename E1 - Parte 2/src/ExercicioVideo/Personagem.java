package ExercicioVideo;

public class Personagem {

    private String nome;
    private String corCoroa;
    private String arma;

    public Personagem(String nome, String corCoroa, String arma) {
        this.nome = nome;
        this.corCoroa = corCoroa;
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorCoroa() {
        return corCoroa;
    }

    public void setCorCoroa(String corCoroa) {
        this.corCoroa = corCoroa;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void defender() {
        System.out.println(nome + " está defendendo!");
    }

    public void atacar() {
        System.out.println(nome + " está atacando com " + arma + "!");
    }

    public void controlar() {
        System.out.println(nome + " está sendo controlado no jogo.");
    }

}
