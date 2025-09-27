

package ExercicioImagem.Imagem2;

public class Torre {
    private String material;
    private int altura;
    private int idade;

    public Torre(String material, int altura, int idade) {
        this.material = material;
        this.altura = altura;
        this.idade = idade;
    }

    public String getMaterial() {
        return material;
    }

    public int getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }



    public void apreciar(){
        System.out.println("Apreciando a torre de " + material + " com " + altura + " metros de altura e " + idade + " anos.");
    }
}
