/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Irla Silva
 */
public enum RequisicaoSQLs {
    INSERT("insert into requisicao(rsp, boletiminformativo, cnpj, razaosocial, nomefantasia, atividades, status) values (?, ?, ?, ?, ?, ?, ?)"), 
    LIST_ALL("select * from requisicao"),
    VALIDATE("select status from usuario where cnpj= ? AND rsp= ?"),
    DELETE("delete from requisicao where rsp=? AND cnpj=?"),
    UPDATE("update requisicao set codLogradouro=?, horario=?, area=?, status=? where rsp=? AND cnpj=?"),
    SEARCH_CNPJ("select rsp from requisicao where cnpj=?"),
    SEARCH_ALVARA("select rsp from requisicao where alvara=?"),
    SEARCH_REQUISICAO("select rsp from requisicao where rsp=?");
    // pesquisar por data
    //pesquisar por usuário
        
    private final String sql;
    RequisicaoSQLs(String sql){
        this.sql = sql;    
    }

    public String getSql() {
        return sql;
    }    
}

