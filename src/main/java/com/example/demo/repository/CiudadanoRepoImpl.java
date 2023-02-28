package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public List<Ciudadano> buscar() {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano_p", Ciudadano.class);
		List<Ciudadano> listaTotal = myQuery.getResultList();
		return listaTotal;
	}

}
