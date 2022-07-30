package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2McFApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(PruebaUnidad2McFApplication.class);
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaMedicaService citaMedicaService;
	

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2McFApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor doc1 = new Doctor();
		doc1.setCedula("165165");
		doc1.setNombre("Juan");
		doc1.setApellido("Hernandes");
		doc1.setFechaNacimiento(LocalDateTime.of(1999, Month.SEPTEMBER,8,12,45));
		doc1.setNumeroConsultorio("AB5");
		doc1.setCodSenecyt("2829");
		doc1.setGenero("masculino");
		
		
		Doctor doc2 = new Doctor();
		doc2.setCedula("21654646");
		doc2.setNombre("Michael");
		doc2.setApellido("Cen");
		doc2.setFechaNacimiento(LocalDateTime.of(1998, Month.SEPTEMBER,8,12,45));
		doc2.setNumeroConsultorio("AB56");
		doc2.setCodSenecyt("28293");
		doc2.setGenero("masculino");
		
		this.doctorService.insertar(doc1);
		this.doctorService.insertar(doc2);
		
		Paciente pac1 = new Paciente();
		pac1.setCedula("1711169183");
		pac1.setNombre("Jose");
		pac1.setApellido("Aguirre");
		pac1.setFechaNacimiento(LocalDateTime.of(2003, Month.MARCH,5,12,30));
		pac1.setCodigo("ja123456");
		pac1.setEstatura("1.80m");
		pac1.setPeso("85kg");
		pac1.setGenero("masculino");
		
		
		Paciente pac2 = new Paciente();
		pac2.setCedula("1711169183");
		pac2.setNombre("Mario");
		pac2.setApellido("Benitez");
		pac2.setFechaNacimiento(LocalDateTime.of(2002, Month.MARCH,4,12,20));
		pac2.setCodigo("MB123456");
		pac2.setEstatura("1.90m");
		pac2.setPeso("98kg");
		pac2.setGenero("masculino");
		
		this.pacienteService.insertar(pac1);
		this.pacienteService.insertar(pac2);
		
		this.citaMedicaService.insertar("1", LocalDateTime.now(), new BigDecimal(15), "Sangolqui", doc1.getCedula(), pac1.getCedula());
		
		this.citaMedicaService.actualizarCitaCompleja("1", "Pulmonia", "Paracetamol", LocalDateTime.of(2022,07,4,11,25)); 
		
		this.citaMedicaService.buscar(LocalDateTime.of(1884,1,1,12,0), "masculino");
		
	}

}
