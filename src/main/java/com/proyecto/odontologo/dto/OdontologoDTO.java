package com.proyecto.odontologo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.proyecto.odontologo.entidades.Odontologo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OdontologoDTO {

	private int idodontologo;
	
	@NotEmpty
	@Size(min = 4, max = 30, message = "la longitud del nombre es entre 4 y 30 caracteres" )
	private String nombre;

	@NotEmpty
	@Size(min = 4, max = 30,  message = "la longitud del apellido es entre 4 y 30 caracteres")
	private String apellido;
	
	private String codigo;
	
	@NotEmpty
	@Size(min = 8, max = 8 , message = "la longitud del dni tiene que ser de 8 digitos")
	private String dni;

	@NotEmpty
	@Size(min = 4, max = 20 , message = "la longitud de la especializacion es entre 4 y 20 caracteres")
	private String especializacion;
	
	@NotEmpty
	@Size(min = 4, max = 20 , message = "la longitud de la matricula es entre 4 y 20 caracteres")
	private String matricula;
	
	@NotEmpty
	@Size(min = 10, max = 12 , message = "la longitud de la matricula es entre 4 y 20 caracteres")
	private String telefono;
	
	@NotEmpty
	@Size(min = 4, max = 20 , message = "la longitud del email es entre 4 y 20 caracteres")
	private String email;
	
	private LocalDate fecharegistro;


	
	
	public Odontologo toEntity(String codigo) {
	    return new Odontologo(
	        this.nombre,
	        this.apellido,
	        this.dni,
	        this.especializacion,
	        this.matricula,
	        this.telefono,
	        this.email,
	        this.fecharegistro);
	}

	
	
	public OdontologoDTO( String nombre, String apellido, String dni,
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



	
	
}
