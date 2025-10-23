package org.example.repository;

import org.example.infraestrutura.database.infraestrutura.Conexao;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean usuarioExiste(String nome) throws SQLException {
        String query = "SELECT nome FROM usuario WHERE nome = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                return true;
            }

        }
        return false;
    }

    public void inserirUser(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome) VALUES (?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.executeQuery();

        }


    }
}
