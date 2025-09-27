package ExercicioVideo;

import ExercicioMusica.Cidade;
import ExercicioMusica.Comida;
import ExercicioMusica.Pessoa;

public class Main {
    public static void main(String[] args) {

        CampoDeBatalha c1 = new CampoDeBatalha("Grande", "verde", "Cavaleiro");
        Personagem p1 = new Personagem("Ryan", "azul", "canhão");
        Torre t1 = new Torre("Rei", "canhão", "Bolas");

        // Chamando métodos
        c1.destruir();
        p1.defender();
        t1.atirar();
    }
}
