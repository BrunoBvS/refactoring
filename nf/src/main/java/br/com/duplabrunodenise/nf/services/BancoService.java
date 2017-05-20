package br.com.duplabrunodenise.nf.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import javax.persistence.Query;

public class BancoService {
	
	BancoService() {}

	private static EntityManager getNewEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        return emf.createEntityManager();
	}

    public static void persisteEntity(Object object) {
        EntityManager em = getNewEntityManager();

        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

    public static Collection findAllEntities(Class classe) {
        EntityManager em = getNewEntityManager();

        Query query = em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e");
        return query.getResultList();
    }

}
