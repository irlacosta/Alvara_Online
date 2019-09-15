package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario usuarioLogado = new Usuario();
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private boolean editando;

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public List<Usuario> getUsuarios() {
        this.usuarios = usuario.listAll();
        return usuarios;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public boolean isEditando() {
        return editando;
    }

    public String salvar() {
        System.out.println("Entrou no salvar - CADASTRAR USUÁRIO");
        if (!isEditando()) {
            usuario.insert();
        }
        this.usuario = new Usuario();
        setEditando(false);
        return "listarUsuarios";
    }

    public String insert() {
        System.out.println("Entrou no CADASTRAR USUÁRIO");
        System.out.println(usuario.toString());
        usuario.insert();
        this.usuario = new Usuario();
        usuarios = usuario.list();
        return "login";
    }

    public String excluir(Usuario user) {
        usuarios.remove(user);
        setEditando(false);
        return "listar";
    }

    public String editar(Usuario user) {
        this.usuario = user;
        setEditando(true);
        return "editar";
    }

    public void limpar() {
        this.usuario = new Usuario();
        setEditando(false);
    }

    public String validar() {
        if (!usuario.validate().isEmpty()) {
            this.usuarioLogado = usuario;
            usuario = new Usuario();
            return "index";
        } else {            
            return "invalido";
        }
    }


    public void clean() {
        this.usuario = new Usuario();
    }

}
