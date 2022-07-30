package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteTO;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
	private static final Logger LOGGER = Logger.getLogger(DoctorRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente = this.buscar(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> query = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula= :datoCedula", Paciente.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public List<PacienteTO> buscarPaciente(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteTO> query = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PacienteTO(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento>:datoFecha and p.genero= :datoGenero",
				PacienteTO.class);
		query.setParameter("datoFecha", fecha);
		query.setParameter("datoGenero", genero);
		List<PacienteTO> reporte = query.getResultList();

		for (PacienteTO paciItem : reporte) {
			LOGGER.info(paciItem);
		}

		return reporte;
	}

}
