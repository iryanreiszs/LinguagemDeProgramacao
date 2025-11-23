package org.example.e2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String apelido;
    private Connector connector = new Connector();

    public Pessoa(int id, String nome, int idade, String apelido) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.apelido = apelido;
    }

    public Pessoa(String nome, int idade, String apelido) {
        this.nome = nome;
        this.idade = idade;
        this.apelido = apelido;
    }

    public Pessoa() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " (" + apelido + "), e tenho " + idade + " anos.");
    }

    // CREATE
    public void inserir(Pessoa p) {
        String sql = "INSERT INTO PESSOA (nome, idade, apelido) VALUES (?, ?, ?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setString(3, p.getApelido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (listar todos)
    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM PESSOA";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa p = new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("apelido")
                );
                pessoas.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    // UPDATE (busca pelo nome ou apelido)
    public void atualizar(Pessoa p) {
        String sql = "UPDATE PESSOA SET nome=?, idade=?, apelido=? WHERE id=?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setString(3, p.getApelido());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM PESSOA WHERE id = ?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
