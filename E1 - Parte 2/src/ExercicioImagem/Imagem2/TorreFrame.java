package ExercicioImagem.Imagem2;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TorreFrame extends JFrame {

    private JTextField txtMaterial, txtAltura, txtIdade;
    private JButton btnCriar;

    public TorreFrame() {
        super("Cadastro de Torre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Material
        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Material:"), c);
        c.gridx = 1;
        txtMaterial = new JTextField(20);
        painel.add(txtMaterial, c);

        // Altura
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Altura (em metros):"), c);
        c.gridx = 1;
        txtAltura = new JTextField(20);
        painel.add(txtAltura, c);

        // Idade
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Idade (em anos):"), c);
        c.gridx = 1;
        txtIdade = new JTextField(20);
        painel.add(txtIdade, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        btnCriar = new JButton("Criar Torre");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {
            Torre torre = new Torre(
                    txtMaterial.getText(),
                    Integer.parseInt(txtAltura.getText()),
                    Integer.parseInt(txtIdade.getText())
            );

            JOptionPane.showMessageDialog(this, "Torre criada: de " + torre.getMaterial() + " com " + torre.getIdade() + " anos de idade");

            try (FileWriter writer = new FileWriter("torre.csv", true)) {
                writer.write(torre.getMaterial() + "," + torre.getAltura() + "," + torre.getIdade() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TorreFrame frame = new TorreFrame();
            frame.setVisible(true);
        });
    }
}
