package com.proyecto.odontologo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.odontologo.entidades.Odontologo;
import com.proyecto.odontologo.dto.OdontologoDTO;
import com.proyecto.odontologo.service.OdontologoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    // 🔹 Crear odontólogo
    @PostMapping("/agregar")
    public ResponseEntity<OdontologoDTO> persistirOdontologo(@Valid @RequestBody OdontologoDTO odontologoDTO) throws Exception {
        // 🔹 Guardamos la entidad y obtenemos el objeto persistido con ID
        Odontologo odontologoGuardado = odontologoService.agregarOdontologo(odontologoDTO);
        
        // 🔹 Convertimos la entidad persistida de vuelta a DTO
        OdontologoDTO dtoResponse = OdontologoDTO.fromEntity(odontologoGuardado);
        
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }


    // 🔹 Buscar por ID
    @GetMapping("/buscarid/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable("id") int id) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorId(id);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Buscar por DNI (nuevo)
    @GetMapping("/buscarPorDni/{dni}")
    public ResponseEntity<Odontologo> buscarPorDni(@PathVariable("dni") String dni) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorDni(dni);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Buscar por nombre
    @GetMapping("/buscarnombre/{nombre}")
    public ResponseEntity<Odontologo> buscarPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorNOmbre(nombre);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Buscar por nombre y apellido
    @GetMapping("/buscarPorapellido/{nombre}/{apellido}")
    public ResponseEntity<Odontologo> buscarPorNombreYApellido(
            @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorNombreYApellido(nombre, apellido);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Listado completo
    @GetMapping("/listado")
    public ResponseEntity<List<Odontologo>> listado() throws Exception {
        return new ResponseEntity<>(odontologoService.listado(), HttpStatus.OK);
    }

    // 🔹 Eliminar odontólogo
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable("id") int idodontologo) throws Exception {
        odontologoService.eliminarOdontologo(idodontologo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
