package ExercicioImagem.Imagem1;

import ExercicioImagem.Cantor;
import ExercicioImagem.Imagem1.Café;
import ExercicioImagem.Imagem1.Caneca;

public class Main {
    public static void main(String[] args) {
        // Criando objetos
        ExercicioImagem.Cantor c1 = new Cantor("João", 25, "Brasil");
        Caneca c2 = new Caneca("Azul", 200, "vidro");
        Café c3= new Café("Amargo", 128888, "Preto");

        // Chamando métodos
        c1.exibir();
        c2.usar();
        c3.tomar();
    }
}

