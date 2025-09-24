public class Cidade {

    private String lugar;
    private int populacao;
    private String pessoa;

    public Cidade(String lugar, int populacao, String pessoa) {
        this.lugar = lugar;
        this.populacao = populacao;
        this.pessoa = pessoa;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public void viajar() {

        System.out.println(pessoa + " está viajando para " + lugar + ".");
    }


}

