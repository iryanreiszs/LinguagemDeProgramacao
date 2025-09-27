package ExercicioImagem.ImagemDoodle;

public class Main {
    public static void main(String[] args) {

        // Criando objetos
        Praia p1 = new Praia("bravo", "clara", "enormes");
        Astronauta a1 = new Astronauta("Ryan", "branco", "pousar na Lua");
        Baleia b1 = new Baleia("Azul", "grande", "Jubarte");

        // Chamando métodos
        p1.relaxar();
        a1.viajar();
        b1.nadar();

    }
}