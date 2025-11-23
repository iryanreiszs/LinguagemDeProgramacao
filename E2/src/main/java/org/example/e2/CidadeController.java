package org.example.e2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CidadeController {

    @FXML
    private TextField lugarField;
    @FXML
    private TextField populacaoField;
    @FXML
    private TextField pessoaField;

    @FXML
    private TableView<Cidade> tabela;
    @FXML
    private TableColumn<Cidade, Integer> colId;
    @FXML
    private TableColumn<Cidade, String> colLugar;
    @FXML
    private TableColumn<Cidade, Integer> colPopulacao;
    @FXML
    private TableColumn<Cidade, String> colPessoa;

    private Cidade dao = new Cidade();
    private ObservableList<Cidade> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(d.getValue().getId()).asObject());
        colLugar.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getLugar()));
        colPopulacao.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(d.getValue().getPopulacao()).asObject());
        colPessoa.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getPessoa()));

        carregarTabela();
    }

    @FXML
    private void cadastrar() {
        String lugar = lugarField.getText();
        int populacao = Integer.parseInt(populacaoField.getText());
        String pessoa = pessoaField.getText();

        Cidade c = new Cidade(lugar, populacao, pessoa);
        dao.inserir(c);

        limpar();
        carregarTabela();
    }

    @FXML
    private void editarSelecionado() {
        Cidade c = tabela.getSelectionModel().getSelectedItem();
        if (c == null) return;

        lugarField.setText(c.getLugar());
        populacaoField.setText(String.valueOf(c.getPopulacao()));
        pessoaField.setText(c.getPessoa());
    }

    @FXML
    private void salvarEdicao() {
        Cidade c = tabela.getSelectionModel().getSelectedItem();
        if (c == null) return;

        c.setLugar(lugarField.getText());
        c.setPopulacao(Integer.parseInt(populacaoField.getText()));
        c.setPessoa(pessoaField.getText());

        dao.atualizar(c);
        carregarTabela();
    }

    @FXML
    private void excluirSelecionado() {
        Cidade c = tabela.getSelectionModel().getSelectedItem();
        if (c == null) return;

        dao.deletar(c.getId());
        carregarTabela();
    }

    private void carregarTabela() {
        lista.setAll(dao.listar());
        tabela.setItems(lista);
    }

    private void limpar() {
        lugarField.clear();
        populacaoField.clear();
        pessoaField.clear();
    }

}
