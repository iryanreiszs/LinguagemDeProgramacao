package ExercicioImagem.Imagem2;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PaísFrame extends javax.swing.JFrame {

    private TextField txtNome, txtPopulação, txtTurismo;
    private JButton btnCriar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaisagemFrame.class.getName());

    public PaísFrame() {
        super("Cadastro de País");
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
        txtNome = new TextField(20);
        painel.add(txtNome, c);

        // Turismo
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Turismo(Para onde vai):"), c);
        c.gridx = 1;
        txtTurismo = new TextField(20);
        painel.add(txtTurismo, c);

        // População
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("População(Local de origem):"), c);
        c.gridx = 1;
        txtPopulação = new TextField(20);
        painel.add(txtPopulação, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Viagem");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {
            País país = new País(txtNome.getText(),txtTurismo.getText() ,Integer.parseInt(txtPopulação.getText()));

            JOptionPane.showMessageDialog(this, "Viagem criada: " + país.getNome() + " foi para " + país.getTurismo() );

            try (FileWriter writer = new FileWriter("países.csv", true)) {
                writer.write(país.getNome() + "," + país.getPopulação() + "," + país.getTurismo() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });


    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            PaísFrame frame = new PaísFrame();
            frame.setVisible(true);
        });
    }


}
