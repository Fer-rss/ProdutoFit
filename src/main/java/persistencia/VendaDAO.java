package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VendaDAO {

    public void cadastrar (Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Venda buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Venda.class, id);
    }

    public List<Venda> listarTodos () {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v", Venda.class);
        return query.getResultList();
    }

    public void atualizar (Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(venda);
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
            Venda venda = em.find(Venda.class, id);
            if (venda != null) {
                em.remove(venda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}

