/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public enum UsuarioSQLs {
    INSERT("insert into usuario(nome, cpf, senha) values (?, ?, ?)"), 
    LIST_ALL("select * from usuario"),
    VALIDATE("select nome from usuario where cpf = ? AND senha = ?"),
    DELETE("delete from usuario where nome=? AND cpf=?"),
    UPDATE("update usuario set nome=?, senha=? where cpf=?"),
    SEARCH_ID("select nome from usuario where cpf=?");
        
    private final String sql;
    UsuarioSQLs(String sql){
        this.sql = sql;    
    }

    public String getSql() {
        return sql;
    }    
}

