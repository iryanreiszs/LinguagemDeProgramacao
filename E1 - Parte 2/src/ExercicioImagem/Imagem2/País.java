package ExercicioImagem.Imagem2;

public class País {

    private static String nome;
    private int população;
    private String turismo;

    public País(String nome, String turismo, int população) {
        this.nome = nome;
        this.população = população;
        this.turismo = turismo;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulação() {
        return população;
    }

    public void setPopulação(int população) {
        this.população = população;
    }

    public String getTurismo() {
        return turismo;
    }

    public void setTurismo(String turismo) {
        this.turismo = turismo;
    }

    public void viajar(){
        System.out.println("A Torre Eiffel fica na " + turismo + "!");
    }

}
