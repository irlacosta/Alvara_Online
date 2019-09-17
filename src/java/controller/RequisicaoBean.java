/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Atividade;
import model.Requisicao;

/**
 *
 * @author Irla Silva
 */
@ManagedBean
@SessionScoped
public class RequisicaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Requisicao requisicao = new Requisicao();
    private List<Requisicao> list;
    private List<String> listStatus;
    private List<Atividade> atividades;
    Atividade atividade = new Atividade();

    //usar a classe RequisicaoBean para:
    //gerenciar cnpj nas requisições
    //bean para cadastro das requisições
    //bean para pesquisas das requisições
    //lista de requisições
    public Requisicao getRequisicao() {
        return requisicao;
    }

    public List<Requisicao> getList() {
        return list;
    }

    public void setList(List<Requisicao> list) {
        this.list = list;
    }

    public List<String> getListStatus() {
        return listStatus;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public void setListRequisicoes(List<Requisicao> listRequisicoes) {
        this.list = listRequisicoes;
    }

    public void setListStatus(List<String> listStatus) {
        this.listStatus = listStatus;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public String edit(Requisicao request) {
        // editar STATUS, TEMPO DE ALVARÁ, ATIVIDADES, ...
        //não esquece o new
        System.out.println("Entrou no editar!!");
        //Requisicao requisicao = new Requisicao();
        requisicao = request;
        return "editar";
    }

    public String update(Requisicao requisicao) {
        System.out.println("Entrou no atualizar!!");
        requisicao.update();
        //requisicao.list();
        return "listar";
    }

    public String insert() {
        System.out.println("Entrou no cadastrar!!");
        System.out.println(requisicao.toString());
        requisicao.insert();
        this.requisicao = new Requisicao();
        list = requisicao.list();
        clean();
        return "listar";
    }

    public void clean() {
        this.requisicao = new Requisicao();
    }

    public String delete(Requisicao requisicao) {
        System.out.println("Entrou no excluir!!");
        requisicao.remove();
        list = requisicao.list();
        return "listar";
    }
}
