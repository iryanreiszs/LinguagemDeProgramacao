package ExercicioMusica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ComidaFrame extends javax.swing.JFrame {

    private JTextField txtNome, txtTipo, txtPreço;
    private JButton btnCriar;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ComidaFrame.class.getName());

    /**
     * Creates new form PessoaFrame
     */
    public ComidaFrame() {
        super("Cadastro de Comida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // espaço entre componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        // Nome
        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Nome:"), c);
        c.gridx = 1;
        txtNome = new JTextField(20);
        painel.add(txtNome, c);

        // Tipo
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Tipo:"), c);
        c.gridx = 1;
        txtTipo = new JTextField(20);
        painel.add(txtTipo, c);

        // Preço
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Preço:"), c);
        c.gridx = 1;
        txtPreço = new JTextField(20);
        painel.add(txtPreço, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Prato");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {

            Comida comida = new Comida(txtNome.getText(), txtTipo.getText(), Integer.parseInt(txtPreço.getText()));

            JOptionPane.showMessageDialog(this, "Prato criado: " + comida.getNome() + " (" + comida.getTipo() + "), " + "de " + comida.getPreco() + " reais.");

            try (FileWriter writer = new FileWriter("comidas.csv", true)) {
                writer.write(comida.getNome() + "," + comida.getTipo() + "," + comida.getPreco() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            ComidaFrame frame = new ComidaFrame();
            frame.setVisible(true);
        });
    }
}

// Variables declaration - do not modify
// End of variables declaration


