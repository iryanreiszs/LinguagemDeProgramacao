package ExercicioImagem.Imagem1;

import ExercicioImagem.Imagem1.Café;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class CaféFrame extends JFrame{

    private TextField txtSabor, txtGrão, txtLíquido;
    private JButton btnCriar;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CaféFrame.class.getName());

    public CaféFrame() {
        super("Cadastro de Café");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // espaço entre componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        // Sabor
        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Sabor:"), c);
        c.gridx = 1;
        txtSabor = new TextField(20);
        painel.add(txtSabor, c);

        // Grão
        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Grão(quantidade):"), c);
        c.gridx = 1;
        txtGrão = new TextField(20);
        painel.add(txtGrão, c);

        // Líquido
        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("líquido(cor):"), c);
        c.gridx = 1;
        txtLíquido = new TextField(20);
        painel.add(txtLíquido, c);

        // Botão
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2; // botão ocupa duas colunas
        btnCriar = new JButton("Criar Café");
        painel.add(btnCriar, c);

        add(painel);

        // Evento do botão
        btnCriar.addActionListener(e -> {

            Café café = new Café(txtSabor.getText(),Integer.parseInt(txtGrão.getText()),txtLíquido.getText());

            JOptionPane.showMessageDialog(this, "Café criada: " + café.getSabor());

            try (FileWriter writer = new FileWriter("cafés.csv", true)) {
                writer.write(café.getSabor() + "," + café.getGrão() + "," + café.getLíquido() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no CSV!");
            }
        });

    }
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(() -> {
            CaféFrame frame = new CaféFrame();
            frame.setVisible(true);
        });
    }

}


