package com.example.dao;

import com.example.domain.Marca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cad(Marca marca) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsandoJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return marca;

    }

}