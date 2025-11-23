package org.example.e2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private void abrirPessoa() {
        abrirTela("hello-view.fxml", "Cadastro de Pessoas");
    }

    @FXML
    private void abrirCidade() {
        abrirTela("cidade-view.fxml", "Cadastro de Cidades");
    }

    @FXML
    private void abrirProduto() {
        abrirTela("comida-view.fxml", "Cadastro de Comidas");
    }

    private void abrirTela(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
