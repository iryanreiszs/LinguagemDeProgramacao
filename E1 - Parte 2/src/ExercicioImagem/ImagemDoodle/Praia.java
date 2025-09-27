package ExercicioImagem.ImagemDoodle;

public class Praia {

    private String mar;
    private String areia;
    private String ondas;

    public Praia(String mar, String areia, String ondas) {
        this.mar = mar;
        this.areia = areia;
        this.ondas = ondas;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public String getAreia() {
        return areia;
    }

    public void setAreia(String areia) {
        this.areia = areia;
    }

    public String getOndas() {
        return ondas;
    }

    public void setOndas(String ondas) {
        this.ondas = ondas;
    }

    public void relaxar() {
        System.out.println("A praia tem areia " + areia + " e ondas " + ondas + "!");
    }
}

