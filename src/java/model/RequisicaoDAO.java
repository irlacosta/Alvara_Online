/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Irla Silva
 */
public class RequisicaoDAO {
     public static boolean validate(Requisicao request) { //busca o status da viabilidade
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(RequisicaoSQLs.VALIDATE.getSql());){
            System.out.println("Conexão aberta! VALIDAR");
            stmt.setString(1, request.getCnpj());
            stmt.setString(2, request.getRsp());
            System.out.println("CNPJ + RSP"+ request.getCnpj() + " " + request.getRsp());             
            System.out.println("Dados Recuperados!");
            ResultSet rs = stmt.executeQuery();
            rs.last();
            if(rs.getRow()>=1) return true;
        }catch(SQLException e){
                System.out.println("exceção com recursos - VALIDAR RequisicaoDAO");
        }
        return false;
         
     }

    public static boolean update(Requisicao request) {
        //posso alterar:
        // codLogradouro
        //atividade
        //horario
        //area
        //status
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(RequisicaoSQLs.UPDATE.getSql());) {
            System.out.println("SQL = " + RequisicaoSQLs.UPDATE.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, request.getRsp());
            stmt.setInt(2, request.getBoletimInformativo());
            stmt.setString(3, request.getCnpj());// andar junto com a consulta observar os sqls enum das consultas
            stmt.setString(4, request.getStatus().toString()); //chamada da enum???
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - ALTERAR campos RequisicaoDAO");
        }
        return false;
    }

    public static boolean delete(Requisicao request) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(RequisicaoSQLs.DELETE.getSql());) {
            stmt.setString(1, request.getRsp());
            stmt.setString(2, request.getCnpj());
            if (stmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - REMOVER RequisicaoDAO");
        }
        return false;
    }

    public static boolean insert(Requisicao request) {

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(RequisicaoSQLs.INSERT.getSql());) {
            stmt.setString(1, request.getRsp()); //gerar número automático
            stmt.setInt(2, request.getBoletimInformativo());
            stmt.setString(3, request.getCnpj());
            stmt.setString(4, request.getStatus().name()); //chamada da enum
            System.out.println("Dados Gravados");
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exceção com recursos - CADASTRAR RequisicaoDAO");
        }
        return false;
    }

    public static List<Requisicao> getList() {
        List<Requisicao> list = new LinkedList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(RequisicaoSQLs.LIST_ALL.getSql());) {
            System.out.println("Conexão aberta - LISTA");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String rsp = rs.getString("rsp");
                int boletiminformativo = rs.getInt("boletiminformativo");
                String cnpj = rs.getString("cnpj");
                String status = rs.getString("status");
                //construtor da Requisicao = String rsp, int boletimInformativo, String cnpj, Status status
                list.add(new Requisicao(rsp, boletiminformativo, cnpj, Status.DEFERIDO)); //outras maneiras de chamar a enum nesse ponto??
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Exceção SQL LISTAR RequisicaoDAO");
        } catch (Exception e) {
            System.out.println("Exceção no código! LISTAR RequisicaoDAO");
        }
        return null;
    }
}
