package org.example.e2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class HelloController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField idadeField;

    @FXML
    private TextField apelidoField;

    @FXML
    private TableView<Pessoa> tabela;

    @FXML
    private TableColumn<Pessoa, Integer> colId;

    @FXML
    private TableColumn<Pessoa, String> colNome;

    @FXML
    private TableColumn<Pessoa, Integer> colIdade;

    @FXML
    private TableColumn<Pessoa, String> colApelido;

    private Pessoa dao = new Pessoa();
    private ObservableList<Pessoa> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Liga colunas ao model
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNome()));
        colIdade.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getIdade()).asObject());
        colApelido.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getApelido()));

        carregarTabela();
    }

    @FXML
    public void cadastrar() {

        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String apelido = apelidoField.getText();

        Pessoa p = new Pessoa(nome, idade, apelido);
        dao.inserir(p);

        limparCampos();
        carregarTabela();
    }

    private void carregarTabela() {
        lista.setAll(dao.listar());
        tabela.setItems(lista);
    }

    private void limparCampos() {
        nomeField.clear();
        idadeField.clear();
        apelidoField.clear();
    }

    @FXML
    private void editarSelecionado() {
        Pessoa selecionada = tabela.getSelectionModel().getSelectedItem();

        if (selecionada != null) {
            // Joga os valores nos campos para edição
            nomeField.setText(selecionada.getNome());
            idadeField.setText(String.valueOf(selecionada.getIdade()));
            apelidoField.setText(selecionada.getApelido());
        }
    }

    @FXML
    private void salvarEdicao() {

        Pessoa selecionada = tabela.getSelectionModel().getSelectedItem();
        if (selecionada == null) {
            return;
        }

        selecionada.setNome(nomeField.getText());
        selecionada.setIdade(Integer.parseInt(idadeField.getText()));
        selecionada.setApelido(apelidoField.getText());

        dao.atualizar(selecionada);
        carregarTabela();
    }

    @FXML
    private void excluirSelecionado() {
        Pessoa selecionada = tabela.getSelectionModel().getSelectedItem();

        if (selecionada == null) {
            return; // nada selecionado → não faz nada
        }

        dao.deletar(selecionada.getId());
        carregarTabela(); // atualiza a tabela
    }
}
