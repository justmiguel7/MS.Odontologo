package com.proyecto.odontologo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.odontologo.entidades.Odontologo;
import com.proyecto.odontologo.dto.OdontologoDTO;
import com.proyecto.odontologo.repository.OdontologoRepository;

@Service
public class OdontologoServiceImp implements OdontologoService{
	
	@Autowired
	private OdontologoRepository odontologoRepository;
	

	@Override
	public Odontologo agregarOdontologo(OdontologoDTO odontologoDTO) throws Exception {
		String codigo = UUID.randomUUID().toString();
		Odontologo odontologo =  odontologoRepository.save(odontologoDTO.toEntity());
		return odontologo;
	}


	@Override
	public Odontologo buscarPorNOmbre(String nombre) throws Exception {
		Optional<Odontologo> optOdontologo = odontologoRepository.findByNombre(nombre);
		return optOdontologo.get();
	}


	@Override
	public List<Odontologo> listado() throws Exception {
		return odontologoRepository.findAll();
	}

  
	@Override
	public Odontologo buscarPorNombreYApellido(String nombre, String apellido) throws Exception {
		Optional<Odontologo> optOdontologo = odontologoRepository.findByNombreAndApellido(nombre, apellido);
		return optOdontologo.get(); 
	}


	@Override
	public void eliminarOdontologo(int idodontologo) throws Exception {
		Integer idBUscado = new Integer(idodontologo);
		Optional<Odontologo> optOdontologo  = odontologoRepository.findById(idBUscado);
		odontologoRepository.delete(optOdontologo.get());
	}
	
    @Override
    public Odontologo buscarPorId(int id) throws Exception {
        Optional<Odontologo> optPaciente = odontologoRepository.findByIdodontologo(id);
        return optPaciente.orElseThrow(() -> new Exception("Paciente no encontrado con id: " + id));
    }
    
    
    @Override
    public Odontologo buscarPorDni(String dni) throws Exception {
        return odontologoRepository.findByDni(dni)
                .orElseThrow(() -> new Exception("Odontologo no encontrado con DNI: " + dni));
    }
}
