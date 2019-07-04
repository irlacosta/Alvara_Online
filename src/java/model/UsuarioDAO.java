/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Irla Silva
 */
public class UsuarioDAO {

    public static boolean validate(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.VALIDATE.getSql());) {
            System.out.println("Conexão aberta!");
            stmt.setString(1, user.getCpf());
            stmt.setString(2, user.getSenha());
            System.out.println("id + senha" + user.getCpf() + " " + user.getSenha());

            System.out.println("Dados Recuperados!");
            ResultSet rs = stmt.executeQuery();
            rs.last();
            if (rs.getRow() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - VALIDAR");
        }
        return false;
    }

    public static boolean update(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.UPDATE.getSql());) {
            System.out.println("SQL = " + UsuarioSQLs.UPDATE.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getCpf());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - ATUALIZAR");
        }
        return false;
    }

    public static boolean delete(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.DELETE.getSql());) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            if (stmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - REMOVER");
        }
        return false;
    }

    public static boolean insert(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.INSERT.getSql());) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getSenha());
            System.out.println("Dados Gravados!");
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - CADASTRAR");
        }
        return false;
    }

    public static List<Usuario> getList() {
        List<Usuario> lista = new LinkedList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.LIST_ALL.getSql());) {
            System.out.println("Conexão aberta - lista!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                lista.add(new Usuario(nome, cpf, senha));
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Exceção SQL");
        } catch (Exception e) {
            System.out.println("Exceção no código! LISTAR UsuarioDAO");
        }
        return null;
    }
}
