package ExercicioImagem.Imagem1;

import ExercicioImagem.Cantor;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;


public class CantorFrame extends JFrame {

    private JTextField txtNome, txtIdade, txtPaís;
    private JButton btnCriar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CantorFrame.class.getName());

    public CantorFrame() {

        super("Cadastro de Cantor");
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

        // Idade
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Idade:"), c);
        c.gridx = 1;
        txtIdade = new JTextField(20);
        painel.add(txtIdade, c);

        // País
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("País:"), c);
        c.gridx = 1;
        txtPaís = new JTextField(20);
        painel.add(txtPaís, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Biografia");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {
            Cantor cantor = new Cantor(txtNome.getText(),Integer.parseInt(txtIdade.getText()),txtPaís.getText());

            JOptionPane.showMessageDialog(this, "Cantor criado: " + cantor.getNome() + " de " + cantor.getIdade() + " anos");

            try (FileWriter writer = new FileWriter("cantores.csv", true)) {
                writer.write(cantor.getNome() + "," + cantor.getIdade() + "," + cantor.getPaís() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });
    }

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            CantorFrame frame = new CantorFrame();
            frame.setVisible(true);
        });

    }


    }

