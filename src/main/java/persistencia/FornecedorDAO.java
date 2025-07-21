package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FornecedorDAO {

    public void cadastrar (Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Fornecedor buscarPorId (Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Fornecedor.class, id);
    }

    public void atualizar(Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(fornecedor);
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
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            if (fornecedor != null) {
                em.remove(fornecedor);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listarTodos () {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
        return query.getResultList();
    }
}

