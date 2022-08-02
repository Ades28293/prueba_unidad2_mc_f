package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

public class PacienteTO {
	private String cedula;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private String genero;

	public PacienteTO() {

	}

	public PacienteTO(String cedula, String nombre, LocalDateTime fechaNacimiento, String genero) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	// SET y GET
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
