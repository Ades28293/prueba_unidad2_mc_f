package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.PacienteTO;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	private static final Logger LOGGER = Logger.getLogger(CitaMedicaServiceImpl.class);

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Autowired
	private IDoctorRepository doctorRepository;
	
	
	@Override
	public void insertar(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoc,
			String cedulaPaci) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica=new CitaMedica();
		
		citaMedica.setNumeCita(numero);
		citaMedica.setFecha(fecha);
		citaMedica.setValor(valor);
		citaMedica.setLugar(lugar);
		citaMedica.setDoctor(this.doctorRepository.buscarCedula(cedulaDoc));
		citaMedica.setPaciente(this.pacienteRepository.buscarCedula(cedulaPaci));
		
		this.citaMedicaRepository.insertar(citaMedica);
			
	}

	@Override
	public void actualizar(String numero, String diagnostico, String receta, LocalDateTime citaProx) {
		// TODO Auto-generated method stub
		
		CitaMedica citaMedica=this.citaMedicaRepository.buscar(numero);
		
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setProxCita(citaProx); 
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public List<PacienteTO> buscar(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		
		return this.pacienteRepository.buscarPaciente(fecha, genero);
	}
	
	@Override
	public int actualizarCitaCompleja(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
	// TODO Auto-generated method stub
	return this.citaMedicaRepository.actualizarCitaCompleja(numero, diagnostico, receta, fechaProxima);
	}
}
