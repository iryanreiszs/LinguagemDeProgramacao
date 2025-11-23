package org.example.e2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ComidaController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField tipoField;
    @FXML
    private TextField precoField;

    @FXML
    private TableView<Comida> tabela;
    @FXML
    private TableColumn<Comida, Integer> colId;
    @FXML
    private TableColumn<Comida, String> colNome;
    @FXML
    private TableColumn<Comida, String> colTipo;
    @FXML
    private TableColumn<Comida, Double> colPreco;

    private Comida dao = new Comida();
    private ObservableList<Comida> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(d.getValue().getId()).asObject());
        colNome.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNome()));
        colTipo.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getTipo()));
        colPreco.setCellValueFactory(d -> new javafx.beans.property.SimpleDoubleProperty(d.getValue().getPreco()).asObject());

        carregarTabela();
    }

    @FXML
    public void cadastrar() {
        Comida c = new Comida(
                nomeField.getText(),
                tipoField.getText(),
                Double.parseDouble(precoField.getText())
        );

        dao.inserir(c);
        limparCampos();
        carregarTabela();
    }

    private void carregarTabela() {
        lista.setAll(dao.listar());
        tabela.setItems(lista);
    }

    private void limparCampos() {
        nomeField.clear();
        tipoField.clear();
        precoField.clear();
    }

    @FXML
    private void editarSelecionado() {
        Comida c = tabela.getSelectionModel().getSelectedItem();

        if (c != null) {
            nomeField.setText(c.getNome());
            tipoField.setText(c.getTipo());
            precoField.setText(String.valueOf(c.getPreco()));
        }
    }

    @FXML
    private void salvarEdicao() {
        Comida c = tabela.getSelectionModel().getSelectedItem();

        if (c == null) return;

        c.setNome(nomeField.getText());
        c.setTipo(tipoField.getText());
        c.setPreco(Double.parseDouble(precoField.getText()));

        dao.atualizar(c);
        carregarTabela();
    }

    @FXML
    private void excluirSelecionado() {
        Comida c = tabela.getSelectionModel().getSelectedItem();

        if (c == null) return;

        dao.deletar(c.getId());
        carregarTabela();
    }
}
