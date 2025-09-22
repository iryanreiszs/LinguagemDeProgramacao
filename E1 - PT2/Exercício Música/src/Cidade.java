public class Cidade {

    private String lugar;
    private String populacao;
    private String pessoa;

    public Cidade(String lugar, String populacao, String pessoa) {
        this.lugar = lugar;
        this.populacao = populacao;
        this.pessoa = pessoa;
    }

    public void viajar() {

        System.out.println(pessoa + " está viajando para " + lugar + ".");
    }


}

