/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author silviacb
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           String urlBD="jdbc:mysql://localhost:3306/bd";
           return DriverManager.getConnection(urlBD, "root", "");
        } catch (SQLException e) {
            System.out.println("Exceção SQL - ConnectionFactory");
        } catch(ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada - ConnectionFactory");
        }
        return null;
    }
}
