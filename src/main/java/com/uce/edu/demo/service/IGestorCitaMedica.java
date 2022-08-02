package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteTO;

public interface IGestorCitaMedica {

	public void generarCita(String numero, LocalDateTime fechaCita, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente);

	public void actualizar(String numero, String diagnostico, String receta, LocalDateTime citaProx);



}
