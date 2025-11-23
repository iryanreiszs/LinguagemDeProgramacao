package org.example.e2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comida {

    private int id;
    private String nome;
    private String tipo;
    private double preco;

    private Connector connector = new Connector();

    public Comida(int id, String nome, String tipo, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Comida(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Comida() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    // CREATE
    public void inserir(Comida c) {
        String sql = "INSERT INTO COMIDA (nome, tipo, preco) VALUES (?, ?, ?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTipo());
            stmt.setDouble(3, c.getPreco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Comida> listar() {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT * FROM COMIDA";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                comidas.add(new Comida(
                        rs.getInt("id"),
                        rs.getString("Nome"),
                        rs.getString("Tipo"),
                        rs.getDouble("Preco")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comidas;
    }

    // UPDATE
    public void atualizar(Comida c) {
        String sql = "UPDATE COMIDA SET nome=?, tipo=?, preco=? WHERE id=?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTipo());
            stmt.setDouble(3, c.getPreco());
            stmt.setInt(4, c.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM COMIDA WHERE id=?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
