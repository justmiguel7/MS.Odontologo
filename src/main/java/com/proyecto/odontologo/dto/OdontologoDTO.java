package com.proyecto.odontologo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.proyecto.odontologo.entidades.Odontologo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Size(min = 10, max = 12, message = "El teléfono debe tener entre 10 y 12 caracteres")
	@Pattern(regexp = "\\d+", message = "El teléfono solo debe contener números")
	private String telefono;
	
	@NotEmpty
	@Size(min = 4, max = 35 , message = "la longitud del email es entre 4 y 35 caracteres")
	private String email;
	
	private LocalDate fecharegistro;

    public OdontologoDTO() {}

	

    // 🔹 Convierte DTO a entidad
    public Odontologo toEntity() {
        Odontologo odontologo = new Odontologo();
        odontologo.setIdodontologo(this.idodontologo);
        odontologo.setNombre(this.nombre);
        odontologo.setApellido(this.apellido);
        odontologo.setDni(this.dni);
        odontologo.setTelefono(this.telefono);
        odontologo.setEmail(this.email);
        odontologo.setMatricula(this.matricula);
        odontologo.setEspecializacion(this.especializacion);
        odontologo.setFecharegistro(this.fecharegistro);
        return odontologo;
    }

    // 🔹 Convierte entidad a DTO
    public static OdontologoDTO fromEntity(Odontologo odontologo) {
        OdontologoDTO dto = new OdontologoDTO();
        dto.setIdodontologo(odontologo.getIdodontologo());
        dto.setNombre(odontologo.getNombre());
        dto.setApellido(odontologo.getApellido());
        dto.setDni(odontologo.getDni());
        dto.setTelefono(odontologo.getTelefono());
        dto.setEmail(odontologo.getEmail());
        dto.setMatricula(odontologo.getMatricula());
        dto.setEspecializacion(odontologo.getEspecializacion());
        dto.setFecharegistro(odontologo.getFecharegistro());
        return dto;
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
