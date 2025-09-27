package ExercicioImagem.ImagemDoodle;

public class Astronauta {

    private String pessoa;
    private String cor;
    private String objetivo;

    public Astronauta(String pessoa, String cor, String objetivo) {
        this.pessoa = pessoa;
        this.cor = cor;
        this.objetivo = objetivo;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void viajar() {
        System.out.println(pessoa + " está viajando para cumprir o objetivo: " + objetivo + "!");
    }
}
