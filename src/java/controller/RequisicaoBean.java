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
import model.Requisicao;

/**
 *
 * @author Irla Silva
 */
@ManagedBean
@SessionScoped
public class RequisicaoBean implements Serializable {

    private static final long serialVersionUID = 356240640918386194L;
    private Requisicao requisicao = new Requisicao();
    private List<Requisicao> list;
    List<String> listStatus;
    

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public List<Requisicao> getList() {
        this.list = requisicao.list();
        return list;
    }

    public void setLista(List<Requisicao> lista) {
        this.list = lista;
    }

    public String edit(Requisicao request) { // editar STATUS, TEMPO DE ALVARÁ, ATIVIDADES, ...
        //não esquece o new
        System.out.println("Entrou no editar!!");
        //Requisicao requisicao = new Requisicao();
        this.requisicao = request;
        return "editar";
    }
  
    public String update(Requisicao request) {
        System.out.println("Entrou no atualizar!!");
        request.update();
        //requisicao.list();
        return "listar";
    }

    public String insert() {
        System.out.println("Entrou no cadastrar!!");
        System.out.println(requisicao.toString());
        requisicao.insert();
        list = requisicao.list();
        clean();
        return "listar";
    }

//    public String validar() {
//        if(usuario.validar()){
//           this.usuarioLogado = usuario;    
//           usuario = new Usuario();
//           return "menu";
//        }
//        return "invalido";
//    }
    public void clean() {
        this.requisicao = new Requisicao();
    }

    public String delete(Requisicao request) {
        System.out.println("Entrou no excluir!!");
        request.delete();
        list = requisicao.list();
        return "listar";
    }

}
