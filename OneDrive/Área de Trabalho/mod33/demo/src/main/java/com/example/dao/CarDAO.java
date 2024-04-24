package com.example.dao;

import com.example.domain.Carro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarDAO implements ICarDAO {

    @Override
    public Carro cad(Carro carro) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MAPEAMENTOJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return carro;

    }
    
}