package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Paciente;

import com.uce.edu.demo.repository.modelo.PacienteTO;

public interface IPacienteRepository {
	public void insertar(Paciente paciente);

	public void eliminar(Integer id);

	public void actualizar(Paciente paciente);

	public Paciente buscar(Integer id);

	public Paciente buscarCedula(String cedula);

	public List<PacienteTO> buscarPaciente(LocalDateTime fecha, String genero);

}
