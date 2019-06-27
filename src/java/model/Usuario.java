package model;

import model.UsuarioDAO;
import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 7371518231621030644L;
    private String nome;
    private String sobrenome;
    private String cpf; //cpf será o login
    private String email;
    private String senha;
    

    public Usuario(){}
    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setLogin(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + '}';
    }

    public List<Usuario> list(){
        return UsuarioDAO.getList();
    }
    
    public boolean insert() {
        return UsuarioDAO.insert(this);
    }
    
    public boolean validate() {
        return UsuarioDAO.validate(this);
    }
    
    public boolean delete(){
        return UsuarioDAO.delete(this);
    }
    
    public boolean update(){
        return UsuarioDAO.update(this);
    }
}
