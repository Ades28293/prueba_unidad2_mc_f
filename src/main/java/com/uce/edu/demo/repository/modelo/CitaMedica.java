package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

	@Id
	@Column(name="cime_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cime_id_seq")
	@SequenceGenerator(name = "cime_id_seq", sequenceName = "cime_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="cime_numero_cita")
	private String numero;
	@Column(name="cime_fecha")
	private LocalDateTime fecha;
	@Column(name="cime_valor")
	private BigDecimal valor;
	@Column(name="cime_lugar")
	private String lugar;
	@Column(name="cime_diagnostico")
	private String diagnostico;
	@Column(name="cime_receta")
	private String receta;
	@Column(name="cime_proxima_cita")
	private LocalDateTime proximaCita;
	
	@ManyToOne()
	@JoinColumn(name="cime_id_doctor")
	private Doctor doctor;
	
	@ManyToOne()
	@JoinColumn(name="cime_id_paciente")
	private Paciente paciente;
	
	
	//SET y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeCita() {
		return numero;
	}
	public void setNumeCita(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public LocalDateTime getProxCita() {
		return proximaCita;
	}
	public void setProxCita(LocalDateTime proxCita) {
		this.proximaCita = proxCita;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", valor=" + valor + ", lugar="
				+ lugar + ", diagnostico=" + diagnostico + ", receta=" + receta + ", proximaCita=" + proximaCita + "]";
	}
	

}
