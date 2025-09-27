package ExercicioVideo;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TorreFrame extends JFrame {

    private JTextField txtPessoa, txtArma, txtMunicao;
    private JButton btnCriar;

    public TorreFrame() {
        super("Cadastro de Torre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Pessoa
        c.gridx = 0; c.gridy = 0;
        painel.add(new JLabel("Pessoa:"), c);
        c.gridx = 1;
        txtPessoa = new JTextField(20);
        painel.add(txtPessoa, c);

        // Arma
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Arma:"), c);
        c.gridx = 1;
        txtArma = new JTextField(20);
        painel.add(txtArma, c);

        // Munição
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Munição:"), c);
        c.gridx = 1;
        txtMunicao = new JTextField(20);
        painel.add(txtMunicao, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Torre");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            Torre torre = new Torre(
                    txtPessoa.getText(),
                    txtArma.getText(),
                    txtMunicao.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Torre criada: pessoa " + torre.getPessoa() + ", arma " + torre.getArma() + ", municao " + torre.getMunicao());

            try (FileWriter writer = new FileWriter("torres.csv", true)) {
                writer.write(torre.getPessoa() + "," + torre.getArma() + "," + torre.getMunicao() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TorreFrame().setVisible(true));
    }
}

