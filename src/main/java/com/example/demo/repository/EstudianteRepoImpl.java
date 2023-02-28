package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		System.out.println("Insertando");
		this.entityManager.persist(estudiante);
	}
	

}
