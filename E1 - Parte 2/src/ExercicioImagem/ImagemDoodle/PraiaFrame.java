package ExercicioImagem.ImagemDoodle;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PraiaFrame extends JFrame {

    private JTextField txtMar, txtAreia, txtOndas;
    private JButton btnCriar;

    public PraiaFrame() {
        super("Cadastro de Praia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Mar
        c.gridx = 0; c.gridy = 0;
        painel.add(new JLabel("Mar:"), c);
        c.gridx = 1;
        txtMar = new JTextField(20);
        painel.add(txtMar, c);

        // Areia
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Areia:"), c);
        c.gridx = 1;
        txtAreia = new JTextField(20);
        painel.add(txtAreia, c);

        // Ondas
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Ondas:"), c);
        c.gridx = 1;
        txtOndas = new JTextField(20);
        painel.add(txtOndas, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Praia");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            Praia praia = new Praia(
                    txtMar.getText(),
                    txtAreia.getText(),
                    txtOndas.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Praia criada:" + praia.getMar() + ", areia " + praia.getAreia() + " e ondas " + praia.getOndas());

            try (FileWriter writer = new FileWriter("praias.csv", true)) {
                writer.write(praia.getMar() + "," + praia.getAreia() + "," + praia.getOndas() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PraiaFrame().setVisible(true));
    }
}

