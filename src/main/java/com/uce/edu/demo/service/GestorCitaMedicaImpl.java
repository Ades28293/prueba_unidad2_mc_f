package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteTO;

@Service
public class GestorCitaMedicaImpl implements IGestorCitaMedica {

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void generarCita(String numero, LocalDateTime fechaCita, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setNumeCita(numero);
		citaMedica.setFecha(fechaCita);
		citaMedica.setValor(valor);
		citaMedica.setLugar(lugar);

		Doctor miDoctor = this.doctorRepository.buscarCedula(cedulaDoctor);
		Paciente miPaciente = this.iPacienteRepository.buscarCedula(cedulaPaciente);

		citaMedica.setDoctor(miDoctor);
		citaMedica.setPaciente(miPaciente);

		this.citaMedicaService.insertar(citaMedica);
	}

	@Override
	public void actualizar(String numero, String diagnostico, String receta, LocalDateTime citaProx) {
		// TODO Auto-generated method stub

		CitaMedica citaMedica = this.citaMedicaRepository.buscar(numero);

		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setProxCita(citaProx);
		this.citaMedicaRepository.actualizar(citaMedica);
	}

}
