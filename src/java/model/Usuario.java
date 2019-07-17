/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Irla Silva
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nome;
    private String cpf; //cpf será o login
    private String email;
    private String senha;

    //relacionamento não dominante - classe fraca é a Usuario
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) //"usuario" nome do atributo na classe forte
    @JoinColumn(name = "id_usuario")
    private List<Requisicao> requisicoes; //um usúario tem várias requisições    

    public Usuario() {}

    public Usuario(String nome, String email, String senha) { //construtor para o UsuarioBean método editar
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(Long id, String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String cpf, String email, String senha) {
        this(-1L, nome, cpf, email, senha);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

    public List<Usuario> listAll() {
        return new UsuarioDAO().listAll();
    }

    public List<Usuario> list() {
        return new UsuarioDAO().listAll();
    }

    public void insert() {
        new UsuarioDAO().insert(this);
    }

    public boolean validate() {
        return UsuarioDAO.validate(this);
    }

    public Integer remove() {
        return new UsuarioDAO().remove(this.getId());
    }

    public void update() {
        new UsuarioDAO().update(this);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", requisicoes=" + requisicoes + '}';
    }

}
