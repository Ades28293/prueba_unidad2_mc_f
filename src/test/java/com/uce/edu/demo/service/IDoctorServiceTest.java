package com.uce.edu.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.Doctor;

@SpringBootTest
@Transactional
@Rollback(true)
class IDoctorServiceTest {

	@Autowired
	private IDoctorService iDoctorCService;

	@Test
	void testCrearDoctor() {

		Doctor d1 = new Doctor();
		d1.setCedula("1236977");
		d1.setNombre("Dennis");
		d1.setApellido("Tapia");
		d1.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		d1.setNumeroConsultorio("1a");
		d1.setCodSenecyt("asd1");
		d1.setGenero("M");
		this.iDoctorCService.insertar(d1);
		assertThat(this.iDoctorCService.buscarCedula(d1.getCedula()).getId()).isNotNull();
	}
	@Test
	void testBuscaDoctorPorId() {
		assertThat(this.iDoctorCService.buscar(1).getApellido()).isNotNull();
	}
	@Test
	void testBuscaDoctorPorCedula() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1236922277");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodSenecyt("asd1");
		doctor.setGenero("M");
		this.iDoctorCService.insertar(doctor);
		Doctor doctorBuscado = this.iDoctorCService.buscarCedula(doctor.getCedula());
		assertEquals(doctor, doctorBuscado);
	}
	@Test
	void testActualizarDoctor() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1231549526");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodSenecyt("asd455");
		doctor.setGenero("M");

		this.iDoctorCService.insertar(doctor);
		Doctor doctorBuscado = this.iDoctorCService.buscarCedula(doctor.getCedula());
		doctorBuscado.setCodSenecyt("121212asad");
		this.iDoctorCService.actualizar(doctorBuscado);
		assertEquals(doctor.getCodSenecyt(), doctorBuscado.getCodSenecyt());
	}
	@Test
	void testEliminarDoctor() {
		Doctor doctorBuscado = this.iDoctorCService.buscarCedula("2335455");
		assertThat(doctorBuscado.getId()).isNotIn(this.iDoctorCService.buscar(1));
	}
}
