package org.example.service;

import org.example.model.Usuario;
import org.example.repository.UserDao;

import java.sql.SQLException;

public class UserService {

    public static void cadastrarUsuario(Usuario usuario) throws SQLException {

        var usuarioDao = new UserDao();


        if (usuarioDao.usuarioExiste(usuario.getNome())) {
            throw new RuntimeException("Usuario já existe");
        }
        usuarioDao.inserirUser(usuario);
    }


}
