package ExercicioImagem.ImagemDoodle;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class BaleiaFrame extends JFrame {

    private JTextField txtCor, txtTamanho, txtTipo;
    private JButton btnCriar;

    public BaleiaFrame() {
        super("Cadastro de Baleia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Cor
        c.gridx = 0; c.gridy = 0;
        painel.add(new JLabel("Cor:"), c);
        c.gridx = 1;
        txtCor = new JTextField(20);
        painel.add(txtCor, c);

        // Tamanho
        c.gridx = 0; c.gridy = 1;
        painel.add(new JLabel("Tamanho:"), c);
        c.gridx = 1;
        txtTamanho = new JTextField(20);
        painel.add(txtTamanho, c);

        // Tipo
        c.gridx = 0; c.gridy = 2;
        painel.add(new JLabel("Tipo:"), c);
        c.gridx = 1;
        txtTipo = new JTextField(20);
        painel.add(txtTipo, c);

        // Botão
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        btnCriar = new JButton("Criar Baleia");
        painel.add(btnCriar, c);

        add(painel);

        btnCriar.addActionListener(e -> {
            Baleia baleia = new Baleia(
                    txtCor.getText(),
                    txtTamanho.getText(),
                    txtTipo.getText()
            );

            JOptionPane.showMessageDialog(this,
                    "Baleia criada: cor " + baleia.getCor() + ", tamanho " + baleia.getTamanho() + ", tipo " + baleia.getTipo());

            try (FileWriter writer = new FileWriter("baleias.csv", true)) {
                writer.write(baleia.getCor() + "," + baleia.getTamanho() + "," + baleia.getTipo() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BaleiaFrame().setVisible(true));
    }
}

