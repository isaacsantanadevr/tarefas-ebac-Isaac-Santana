package com.example.dao;

import com.example.domain.Acessorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDAO implements IAcessorioDAO {

    @Override
    public Acessorio cad(Acessorio acessorio) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MAPEAMENTOJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return acessorio;

    }
    
}