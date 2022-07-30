package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteTO;

public interface ICitaMedicaService {

	public void insertar(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoc,
			String cedulaPaci);

	public void actualizar(String numero, String diagnostico, String receta, LocalDateTime citaProx);

	public List<PacienteTO> buscar(LocalDateTime fecha, String genero);

	public int actualizarCitaCompleja(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);

}
