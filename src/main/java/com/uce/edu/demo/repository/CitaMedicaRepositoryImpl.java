package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	private static final Logger LOGGER = Logger.getLogger(DoctorRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> query = this.entityManager
				.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.numero= :datoNumero", CitaMedica.class);
		query.setParameter("datoNumero", numero);
		return query.getSingleResult();
	}

	@Override
	public int actualizarCitaCompleja(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager.createQuery(
				"UPDATE CitaMedica c SET c.diagnostico= :datoDiagnostico,c.receta= :datoReceta,c.proximaCita= :datoFechaProxima WHERE c.numero= :datoNumeroCita");
		myQuery.setParameter("datoNumeroCita", numero);
		myQuery.setParameter("datoDiagnostico", diagnostico);
		myQuery.setParameter("datoReceta", receta);
		myQuery.setParameter("datoFechaProxima", fechaProxima);
		return myQuery.executeUpdate();

	}
}
