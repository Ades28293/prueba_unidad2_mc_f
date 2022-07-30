package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {
	private static final Logger LOGGER = Logger.getLogger(DoctorRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Doctor doctor=this.buscar(id);
		this.entityManager.remove(doctor);
		
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public Doctor buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Doctor>query=this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula= :datoCedula",Doctor.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}
	

}
