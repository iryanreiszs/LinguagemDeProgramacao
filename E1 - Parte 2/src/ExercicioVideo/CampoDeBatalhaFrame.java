package ExercicioVideo;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class CampoDeBatalhaFrame extends JFrame {

    private JTextField txtTorres, txtGrama, txtPersonagens;
    private JButton btnCriar;

    public CampoDeBatalhaFrame() {
        super("Cadastro de Campo de Batalha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Torres
        c.gridx = 0; c.gridy = 0;
        painel.add(new JLabel("Torres:"), c);
        c.gridx = 1;
        txtTorres = new JTextField(20);
        painel.add(txtTorres, c);

        // Grama
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Grama:"), c);
        c.gridx = 1;
        txtGrama = new JTextField(20);
        painel.add(txtGrama, c);

        // Personagens
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Personagens:"), c);
        c.gridx = 1;
        txtPersonagens = new JTextField(20);
        painel.add(txtPersonagens, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Campo de Batalha");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            CampoDeBatalha campo = new CampoDeBatalha(
                    txtTorres.getText(),
                    txtGrama.getText(),
                    txtPersonagens.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Campo criado: torres " + campo.getTorres() + ", grama " + campo.getGrama() + ", personagens " + campo.getPersonagens());

            try (FileWriter writer = new FileWriter("campos.csv", true)) {
                writer.write(campo.getTorres() + "," + campo.getGrama() + "," + campo.getPersonagens() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampoDeBatalhaFrame().setVisible(true));
    }
}
