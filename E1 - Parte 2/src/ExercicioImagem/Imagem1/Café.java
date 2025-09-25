package ExercicioImagem;

public class Café {

    private String sabor;
    private int grão;
    private String líquido;

    public Café(String sabor, int grão, String líquido) {
        this.sabor = sabor;
        this.grão = grão;
        this.líquido = líquido;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getGrão() {
        return grão;
    }

    public void setGrão(int grão) {
        this.grão = grão;
    }

    public String getLíquido() {
        return líquido;
    }

    public void setLíquido(String líquido) {
        this.líquido = líquido;
    }

    public void tomar(){
        System.out.println("O sabor do café é" + sabor);
    }

}
