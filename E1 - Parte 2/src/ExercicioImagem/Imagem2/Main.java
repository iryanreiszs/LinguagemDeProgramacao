package ExercicioImagem.Imagem2;

public class Main {
    public static void main(String[] args) {
        // Criando objetos
        Paisagem p1 = new Paisagem("Grande", 2, "Grande");
        País p2 = new País("Ryan", "França", 400000);
        Torre t1 = new Torre("Ferro", 125, 150);

        // Chamando métodos
        p1.vizualizar();
        p2.viajar();
        t1.apreciar();
    }
}
