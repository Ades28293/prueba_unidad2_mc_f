package com.uce.edu.demo.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	private static final Logger LOGGER = Logger.getLogger(CitaMedicaServiceImpl.class);

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void insertar(CitaMedica citaMedica) {

		this.citaMedicaRepository.insertar(citaMedica);

	}

}
