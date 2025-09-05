
public class Main {


    public static void main(String[] args) {
        Personagem personagem = new Personagem();
        personagem.defender("Ryan" , "canhão");
        personagem.atacar("inimigos");
        personagem.controlar("partida");
    
        CampoDeBatalha campodebatalha = new CampoDeBatalha();
        campodebatalha.destruir("Bárbaros" , "inimiga");
        campodebatalha.assistir("jogar");
        campodebatalha.torcer("ganhar");
    
        Torre torre = new Torre();
        torre.derrubarInimigos("Rei", "canhão");
        torre.atirar("inimigos");
        torre.defender("destruída");
    
    
    
    }
    
}
