package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ItemVendaDAO {

    public void cadastrar (ItemVenda item) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public ItemVenda buscarPorID(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(ItemVenda.class, id);
    }

    public void atualizar (ItemVenda item) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(item);
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
            ItemVenda item = em.find(ItemVenda.class, id);
            if (item != null) {
                em.remove(item);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<ItemVenda> listarTodos () {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<ItemVenda> query = em.createQuery("SELECT i FROM ItemVenda i", ItemVenda.class);
        return query.getResultList();
    }
}

