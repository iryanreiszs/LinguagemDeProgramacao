package ExercicioImagem.Imagem1;

public class Caneca {

    private String cor;
    private int capacidade;
    private String material;

    public Caneca(String cor, int capacidade, String material) {
        this.cor = cor;
        this.capacidade = capacidade;
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void usar(){
        System.out.println("A caneca de cor " + cor + " possui " + capacidade + " mL de capacidade");
    }

}
