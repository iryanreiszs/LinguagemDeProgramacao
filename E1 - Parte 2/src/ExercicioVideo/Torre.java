package ExercicioVideo;

import javax.swing.*;

public class Torre {

    private String pessoa;
    private String arma;
    private String municao;

    public Torre(String pessoa, String arma, String municao) {
        this.pessoa = pessoa;
        this.arma = arma;
        this.municao = municao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getMunicao() {
        return municao;
    }

    public void setMunição(String municao) {
        this.municao = municao;
    }

    public void derrubarInimigos() {
        System.out.println(pessoa + " derrubou inimigos usando " + arma + "!");
    }

    public void atirar() {
        System.out.println(pessoa + " está atirando com " + arma + ".");
    }

    public void defender() {
        System.out.println(pessoa + " está defendendo a torre!");
    }

}
