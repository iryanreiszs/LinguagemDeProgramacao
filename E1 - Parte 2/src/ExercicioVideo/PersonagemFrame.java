package ExercicioVideo;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PersonagemFrame extends JFrame {

    private JTextField txtNome, txtCorCoroa, txtArma;
    private JButton btnCriar;

    public PersonagemFrame() {
        super("Cadastro de Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Nome
        c.gridx = 0; c.gridy = 0;
        painel.add(new JLabel("Nome:"), c);
        c.gridx = 1;
        txtNome = new JTextField(20);
        painel.add(txtNome, c);

        // Cor da Coroa
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Cor da Coroa:"), c);
        c.gridx = 1;
        txtCorCoroa = new JTextField(20);
        painel.add(txtCorCoroa, c);

        // Arma
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Arma:"), c);
        c.gridx = 1;
        txtArma = new JTextField(20);
        painel.add(txtArma, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Personagem");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            Personagem personagem = new Personagem(
                    txtNome.getText(),
                    txtCorCoroa.getText(),
                    txtArma.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Personagem criado: " + personagem.getNome() + ", cor da coroa " + personagem.getCorCoroa() + ", arma " + personagem.getArma());

            try (FileWriter writer = new FileWriter("personagens.csv", true)) {
                writer.write(personagem.getNome() + "," + personagem.getCorCoroa() + "," + personagem.getArma() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonagemFrame().setVisible(true));
    }
}

