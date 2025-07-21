package persistencia;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author ferna
 */
public class JPAUtil {
     //constante para centralizar o nome da unidade de persistência
    private static final String PERSISTENCE_UNIT = "ProdutofitPU";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    //cria a entidade se estiver nula e a retorna
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen())
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(em == null || !em.isOpen()) //cria se em nulo ou se o entity manager foi fechado
            em = fabrica.createEntityManager();

        return em;
    }
    
    /** @author Fernando  */
    //fecha o EntityManager e o factory
    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    } 
}
