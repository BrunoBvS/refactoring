package br.com.duplabrunodenise.nf.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BancoService {
	
	BancoService() {}

    public static void persisteEntity(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(object);

        em.getTransaction().commit();
        em.close();
    }

}
