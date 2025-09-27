package ExercicioImagem.ImagemDoodle;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class AstronautaFrame extends JFrame {

    private JTextField txtPessoa, txtCor, txtObjetivo;
    private JButton btnCriar;

    public AstronautaFrame() {
        super("Cadastro de Astronauta");
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

        // Cor
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Cor:"), c);
        c.gridx = 1;
        txtCor = new JTextField(20);
        painel.add(txtCor, c);

        // Objetivo
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Objetivo:"), c);
        c.gridx = 1;
        txtObjetivo = new JTextField(20);
        painel.add(txtObjetivo, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Astronauta");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            Astronauta astro = new Astronauta(
                    txtPessoa.getText(),
                    txtCor.getText(),
                    txtObjetivo.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Astronauta criado: " + astro.getPessoa() + ", cor " + astro.getCor() + ", objetivo " + astro.getObjetivo());

            try (FileWriter writer = new FileWriter("astronautas.csv", true)) {
                writer.write(astro.getPessoa() + "," + astro.getCor() + "," + astro.getObjetivo() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AstronautaFrame().setVisible(true));
    }
}

