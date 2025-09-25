package ExercicioImagem;

public class Main {
    public static void main(String[] args) {
        // Criando objetos
        Cantor c1 = new Cantor("João", 25, "Brasil");
        Caneca c2 = new Caneca("Azul", 200, "vidro");
        Café c3= new Café("Amargo", 128888, "Preto");

        // Chamando métodos
        c1.exibir();
        c2.usar();
        c3.tomar();
    }
}

