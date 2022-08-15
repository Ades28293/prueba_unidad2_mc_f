package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteTO;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedica;
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
	
	@Autowired
	private IGestorCitaMedica citaMedica;
	

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2McFApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor doct1 = new Doctor();
		doct1.setCedula("2335455");
		doct1.setNombre("Daniel");
		doct1.setApellido("Quiñones");
		doct1.setFechaNacimiento(LocalDateTime.of(1997, Month.SEPTEMBER,9,12,45));
		doct1.setNumeroConsultorio("ACB5");
		doct1.setCodSenecyt("654654");
		doct1.setGenero("masculino");
		
		
		Doctor doct2 = new Doctor();
		doct2.setCedula("2421742");
		doct2.setNombre("Karol");
		doct2.setApellido("Aguilar");
		doct2.setFechaNacimiento(LocalDateTime.of(1998, Month.SEPTEMBER,8,12,45));
		doct2.setNumeroConsultorio("AF15");
		doct2.setCodSenecyt("68476");
		doct2.setGenero("masculino");
//		
//	this.doctorService.insertar(doct1);
//	this.doctorService.insertar(doct2);
		
		Paciente paci1 = new Paciente();
		paci1.setCedula("53465761");
		paci1.setNombre("Andres");
		paci1.setApellido("Saimatama");
		paci1.setFechaNacimiento(LocalDateTime.of(2003, Month.MARCH,5,12,30));
		paci1.setCodigo("ja123456");
		paci1.setEstatura(1.80);
		paci1.setPeso(80.0);
		paci1.setGenero("masculino");
		
		
		Paciente paci2 = new Paciente();
		paci2.setCedula("14526887");
		paci2.setNombre("Riquelme");
		paci2.setApellido("Vera");
		paci2.setFechaNacimiento(LocalDateTime.of(2005, Month.MARCH,4,12,20));
		paci2.setCodigo("BHGAS546");
		paci2.setEstatura(1.90);
		paci2.setPeso(98.0);
		paci2.setGenero("masculino");
		
//		this.pacienteService.insertar(paci1);
//		this.pacienteService.insertar(paci2);
//		
//		this.citaMedica.generarCita("1", LocalDateTime.now(), new BigDecimal(15), "Conocoto", "2335455", "14526887");
		
		
//		this.citaMedica.actualizar("1", "Pulmonia", "Paracetamol", LocalDateTime.of(2022,07,4,11,25)); 
		
		
	List<PacienteTO> pa=this.pacienteService.buscarPaciente(LocalDateTime.of(1884,1,1,12,0), "masculino");
		for(PacienteTO Item: pa) {
			LOGGER.info(Item);
		}
	}

}
