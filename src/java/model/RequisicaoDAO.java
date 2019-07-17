package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RequisicaoDAO {
    private EntityManager em;

    public RequisicaoDAO() {}

    public void insert(Requisicao requisicao) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(requisicao);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Requisicao requisicao) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(requisicao);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(long id) {
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Requisicao entity = em.find(Requisicao.class, id);
        if (entity != null) {
            em.remove(entity);
        } else {
            throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Requisicao> listAll() {
        em = JPAUtil.getEntityManager();
        TypedQuery<Requisicao> query
                = em.createQuery(
                       "SELECT r FROM Requisicao r",
                        Requisicao.class);
        List<Requisicao> requisicoes = query.getResultList();
        em.close();
        return requisicoes;
    }

    
    public List<Requisicao> find(String rsp) {
        em = JPAUtil.getEntityManager();
        TypedQuery<Requisicao> query = em.createQuery(
                "SELECT r FROM Requisicao r "
                + "where lower(r.rsp) like '%"
                + rsp + "%'",
                Requisicao.class);
        List<Requisicao> requisicoes = query.getResultList();
        em.close();
        return requisicoes;
    }
}
