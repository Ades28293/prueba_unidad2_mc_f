package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	

	public void insertar (CitaMedica citaMedica);
	
	public void actualizar (CitaMedica citaMedica);
	
	public CitaMedica buscar (String numero);
	
	
	
}
