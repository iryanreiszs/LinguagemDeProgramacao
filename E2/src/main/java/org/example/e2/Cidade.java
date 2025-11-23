package org.example.e2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cidade {

    private int id;
    private String lugar;
    private int populacao;
    private String pessoa;

    private Connector connector = new Connector();

    public Cidade() {}

    public Cidade(int id, String lugar, int populacao, String pessoa) {
        this.id = id;
        this.lugar = lugar;
        this.populacao = populacao;
        this.pessoa = pessoa;
    }

    public Cidade(String lugar, int populacao, String pessoa) {
        this.lugar = lugar;
        this.populacao = populacao;
        this.pessoa = pessoa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public int getPopulacao() { return populacao; }
    public void setPopulacao(int populacao) { this.populacao = populacao; }

    public String getPessoa() { return pessoa; }
    public void setPessoa(String pessoa) { this.pessoa = pessoa; }

    // CREATE
    public void inserir(Cidade c) {
        String sql = "INSERT INTO CIDADE (lugar, populacao, pessoa) VALUES (?, ?, ?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getLugar());
            stmt.setInt(2, c.getPopulacao());
            stmt.setString(3, c.getPessoa());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Cidade> listar() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM CIDADE";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                cidades.add(new Cidade(
                        rs.getInt("id"),
                        rs.getString("lugar"),
                        rs.getInt("populacao"),
                        rs.getString("pessoa")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    // UPDATE
    public void atualizar(Cidade c) {
        String sql = "UPDATE CIDADE SET lugar=?, populacao=?, pessoa=? WHERE id=?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getLugar());
            stmt.setInt(2, c.getPopulacao());
            stmt.setString(3, c.getPessoa());
            stmt.setInt(4, c.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM CIDADE WHERE id=?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


