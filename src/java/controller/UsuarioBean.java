package controller;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Analista;
import model.Requerente;
import model.Usuario;


@ManagedBean
@SessionScoped
 public class UsuarioBean implements Serializable{
    private Usuario usuarioLogado = new Usuario();
    private Requerente requerente = new Requerente();
    private Analista analista = new Analista();
    private Usuario usuario = new Usuario();
    private LinkedList<Usuario> usuarios = new LinkedList();
    private boolean editando;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    
    public LinkedList<Usuario> getUsuarios() {
        if (usuarios == null) {
            this.usuarios = new LinkedList<>();
        }
        return usuarios;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public String salvar() {
        if (!isEditando()) {
            usuarios.add(new Usuario(usuario.getNome(), usuario.getCpf(), usuario.getSenha()));
        }
        this.usuario = new Usuario();
        setEditando(false);
        return "listar";
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
        //usar aqui o validar conectando com o banco de dados
        if ("admin".equals(usuario.getCpf()) && "admin".equals(usuario.getSenha())) {
            this.usuarioLogado = usuario;    
            usuario = new Usuario();
            return "index";
        } else {
            return "invalido";
        }
    }
    
    public String cadastrar(){
        System.out.println("Entrou no cadastrar usuário!!");
        usuario.insert();
        //usuario.listar();
        return "listar";
    }
    
}
