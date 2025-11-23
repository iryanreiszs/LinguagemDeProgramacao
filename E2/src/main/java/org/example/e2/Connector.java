package org.example.e2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    /**

     Obtém uma conexão com o banco de dados*/
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/MUSICA?useTimezone=true&serverTimezone=UTC", "ryan", "pass123");}
}
