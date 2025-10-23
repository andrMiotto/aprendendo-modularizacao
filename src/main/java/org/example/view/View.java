package org.example.view;

import org.example.model.Usuario;
import org.example.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);

    public static void inicio() throws SQLException {

        System.out.println("1- Cadastrar usuario");

        int opcao = sc.nextInt();
        sc.nextLine();


        switch (opcao) {
            case 1: {
                cadastrarUsuario();


                break;
            }
        }


    }


    public static void cadastrarUsuario() throws SQLException {
        System.out.println("CADASTRAR USUARIO");

        System.out.println("Digite o nome do usuario: ");
        String nome = sc.nextLine();

        var usuario = new Usuario(nome);
        try {
            UserService.cadastrarUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }


}
