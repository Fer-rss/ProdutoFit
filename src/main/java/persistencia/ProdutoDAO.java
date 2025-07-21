/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author ferna
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProdutoDAO {

    public void cadastrar (Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Produto buscarPorId (Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Produto.class, id);
    }

    public void atualizar (Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void excluir (Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Produto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
}