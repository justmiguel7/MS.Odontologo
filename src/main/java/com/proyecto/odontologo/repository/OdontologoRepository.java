package com.proyecto.odontologo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.odontologo.entidades.Odontologo;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer>{
	
	public Optional<Odontologo> findByNombre (String nombre) throws Exception; 
	
	public Optional<Odontologo> findByNombreAndApellido (String nombre, String apellido) throws Exception; 

	public Optional <Odontologo> findByIdodontologo (int odontologoid) throws Exception; 
	
    public Optional<Odontologo> findByDni(String dni) throws Exception;

    
}
