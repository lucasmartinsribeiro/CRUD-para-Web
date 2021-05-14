package model.dao;

import model.Jogos;

import javax.persistence.EntityManager;
import java.util.List;

public class JogoDaoJpa implements InterfaceDao<Jogos> {
    @Override
    public void incluir(Jogos entidade) throws Exception {

        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Jogos entidade) throws Exception {

        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Jogos entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Jogos j = em.find(Jogos.class, entidade.getId());
            em.remove(j);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Jogos pesquisarporId(int id) throws Exception {
        Jogos j = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            j = em.find(Jogos.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return j;
    }

    @Override
    public List<Jogos> pesquisarporNome(String nome) throws Exception {
        List<Jogos> list = null;
        EntityManager em = ConnFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT j FROM Jogos j WHERE j.nome = :nome").setParameter("nome", nome).getResultList();

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<Jogos> listar() throws Exception {
        List<Jogos> list = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT j FROM Jogos j").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return list;
    }
}
