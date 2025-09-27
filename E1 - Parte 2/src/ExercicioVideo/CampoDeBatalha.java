package ExercicioVideo;

public class CampoDeBatalha {

    private String torres;
    private String grama;
    private String personagens;

    public CampoDeBatalha(String torres, String grama, String personagens) {
        this.torres = torres;
        this.grama = grama;
        this.personagens = personagens;
    }

    public String getTorres() {
        return torres;
    }

    public void setTorres(String torres) {
        this.torres = torres;
    }

    public String getGrama() {
        return grama;
    }

    public void setGrama(String grama) {
        this.grama = grama;
    }

    public String getPersonagens() {
        return personagens;
    }

    public void setPersonagens(String personagens) {
        this.personagens = personagens;
    }

    public void destruir() {
        System.out.println("As " + torres + " foram destruídas!");
    }

    public void assistir() {
        System.out.println("Você está assistindo a batalha.");
    }

    public void torcer() {
        System.out.println("Você está torcendo pelos " + personagens + ".");
    }

}
