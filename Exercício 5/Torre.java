
public class Torre {
    
    private String pessoa;
    private String arma;
    private String munição;
    
    public void derrubarInimigos(String pessoa, String arma ) {
        System.out.println("O " + pessoa + " utiliza seu " + arma + " para neutralizar seus inimigos!" );
    }
    
    public void atirar(String a){
        System.out.println("A torre neutraliza os" +a+ "!");
    }
    
    public void defender(String d){
        System.out.println("A torre se defende para nao ser" +d+ "!");
        System.out.println("---------------------------------");
    }
}
