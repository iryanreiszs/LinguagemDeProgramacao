package ExercicioImagem.Imagem2;

public class Paisagem {

    private String árvore;
    private int casa;
    private  String torre;

    public Paisagem(String árvore, int casa, String torre) {
        this.árvore = árvore;
        this.casa = casa;
        this.torre = torre;
    }

    public String getÁrvore() {
        return árvore;
    }

    public void setÁrvore(String árvore) {
        this.árvore = árvore;
    }

    public int getCasa() {
        return casa;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public void vizualizar(){
        System.out.println("Existem " + casa + " casas ao lado da Torre Eiffel");
    }

}

