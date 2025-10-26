package com.proyecto.odontologo.entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Odontologo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idodontologo;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni")
	private String dni;

	@Column(name = "especializacion")
	private String especializacion;

	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fecharegistro")
	private LocalDate fecharegistro;
	


	public Odontologo( String nombre, String apellido, String dni,
			String especializacion, String matricula, String telefono, String email, LocalDate fecharegistro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.especializacion = especializacion;
		this.matricula = matricula;
		this.telefono = telefono;
		this.email = email;
		this.fecharegistro = fecharegistro;
	}
	
	
	public Odontologo(){
		
	}
}
