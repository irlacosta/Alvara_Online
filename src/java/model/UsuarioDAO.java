/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Irla Silva
 */
public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO() {}
    
    
    static boolean validate(Usuario aThis) { //arrumar este método*****
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void insert(Usuario usuario) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Usuario usuario) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Integer remove(long id) {
        Integer retorno = -1;
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Usuario entity = em.find(Usuario.class, id);
        if (entity != null) {
            em.remove(entity);
            retorno = 1;
        } else {
            throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    public Usuario find(int id) {
        em = JPAUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public List<Usuario> listAll() {
        em = JPAUtil.getEntityManager();
        TypedQuery<Usuario> query
                = em.createQuery(
                       "SELECT u FROM Usuario u",
                        Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }

    public List<Usuario> findLogin(String nome) {
        em = JPAUtil.getEntityManager();
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u "
                + "where lower(p.login) like '%"
                + nome.toLowerCase() + "%'",
                Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }
}
