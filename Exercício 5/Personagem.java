public class Personagem {
    
    private String nome;
    private String corCoroa;
    private String arma;
    
    public void defender(String nome, String arma) {
        System.out.println("O Rei " + nome + " usa o " + arma + " para defender sua torre!");
    }
    public void atacar(String i){
        System.out.println("O Rei ataca os " +i+ "!");
    }
    public void controlar(String p){
        System.out.println("O Rei controla a " +p+ "!");
        System.out.println("---------------------------------");
    }
}
