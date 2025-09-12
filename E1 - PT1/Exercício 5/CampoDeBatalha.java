
public class CampoDeBatalha {
    
     private String torre;
     private String grama;
     private String personagens;
     
     public void destruir(String personagens, String torre) {
         System.out.println("Os " + personagens + " vão em direção à torre " + torre + " para atacar!");
    }
     
    public void assistir(String a){
        System.out.println("Os bonecos assistem o " +a+ "!");
    }
    public void torcer(String g){
        System.out.println("Os personagens torcem para alguém" +g+ "!");
        System.out.println("---------------------------------");
    }
    
} 
