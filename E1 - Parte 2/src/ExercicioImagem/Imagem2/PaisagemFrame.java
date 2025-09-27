package ExercicioImagem.Imagem2;

import ExercicioMusica.Comida;
import ExercicioMusica.ComidaFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class PaisagemFrame  extends javax.swing.JFrame {

    private TextField txtÁrvore, txtCasa, txtTorre;
    private JButton btnCriar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaisagemFrame.class.getName());

    public PaisagemFrame() {
        super("Cadastro de Paisagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // espaço entre componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        // Arvore
        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Árvore(tamanho):"), c);
        c.gridx = 1;
        txtÁrvore = new TextField(20);
        painel.add(txtÁrvore, c);

        // Casa
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Casa(quantidade):"), c);
        c.gridx = 1;
        txtCasa = new TextField(20);
        painel.add(txtCasa, c);

        // Torre
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Torre(tamanho):"), c);
        c.gridx = 1;
        txtTorre = new TextField(20);
        painel.add(txtTorre, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Paisagem");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {
            Paisagem paisagem = new Paisagem(txtÁrvore.getText(), Integer.parseInt(txtCasa.getText()),txtTorre.getText());

            JOptionPane.showMessageDialog(this, "Paisagem criada: existem " + paisagem.getCasa() + " casas do lado da Torre Eiffel");

            try (FileWriter writer = new FileWriter("paisagens.csv", true)) {
                writer.write(paisagem.getÁrvore() + "," + paisagem.getCasa() + "," + paisagem.getTorre() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });


    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            PaisagemFrame frame = new PaisagemFrame();
            frame.setVisible(true);
        });
    }

}
