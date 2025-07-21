/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO {

    public void cadastrar (Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } 
    }

    public Cliente buscarPorId (Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            // Opcional: você pode deixar o EM aberto (como seu JPAUtil faz)
        }
    }

    public void atualizar (Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } 
    }

    public void excluir (Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } 
    }

    public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } finally {
            // Opcional
        }
    }
}

