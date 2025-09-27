package ExercicioImagem.Imagem1;

import ExercicioImagem.Imagem1.Caneca;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class CanecaFrame extends JFrame{

    private JTextField txtCor, txtCapacidade, txtMaterial;
    private JButton btnCriar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CanecaFrame.class.getName());

    public CanecaFrame(){

        super("Cadastro de Caneca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // espaço entre componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        // Cor
        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Cor:"), c);
        c.gridx = 1;
        txtCor = new JTextField(20);
        painel.add(txtCor, c);

        // Capacidade
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Capacidade:"), c);
        c.gridx = 1;
        txtCapacidade = new JTextField(20);
        painel.add(txtCapacidade, c);

        // Material
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Material:"), c);
        c.gridx = 1;
        txtMaterial = new JTextField(20);
        painel.add(txtMaterial, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Caneca");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {


            Caneca caneca = new Caneca(txtCor.getText(),Integer.parseInt(txtCapacidade.getText()),txtMaterial.getText());

            JOptionPane.showMessageDialog(this, "Caneca criada: " + caneca.getCor() + " de " + caneca.getCapacidade() + " mL");

            try (FileWriter writer = new FileWriter("canecas.csv", true)) {
                writer.write(caneca.getCor() + "," + caneca.getCapacidade() + "," + caneca.getMaterial() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });

        }
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            CanecaFrame frame = new CanecaFrame();
            frame.setVisible(true);
        });
    }

}
