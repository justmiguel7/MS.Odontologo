package com.proyecto.odontologo.service;

import java.util.List;

import com.proyecto.odontologo.entidades.Odontologo;
import com.proyecto.odontologo.dto.OdontologoDTO;

public interface OdontologoService {
	
	public Odontologo agregarOdontologo(OdontologoDTO odontologoDTO ) throws Exception;

	public Odontologo buscarPorNOmbre (String nombre) throws Exception;

	public Odontologo buscarPorNombreYApellido (String nombre, String apellido) throws Exception;

	public List<Odontologo> listado () throws Exception;

	public void eliminarOdontologo (int idodontologo) throws Exception;
	
	public Odontologo buscarPorId (int id) throws Exception;
}
