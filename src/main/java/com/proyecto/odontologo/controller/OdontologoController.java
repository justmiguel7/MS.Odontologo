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
    @RequestMapping(value = "/agregar", method = {RequestMethod.POST})
    public ResponseEntity<OdontologoDTO> persistirOdontologo(@Valid @RequestBody OdontologoDTO odontologoDTO) throws Exception {
        odontologoService.agregarOdontologo(odontologoDTO);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.CREATED);
    }

    // 🔹 Buscar por ID (✅ usado por el BFF)
    @RequestMapping(value = "/buscarid/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable("id") int id) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorId(id);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Buscar por nombre
    @RequestMapping(value = "/buscarnombre/{nombre}", method = {RequestMethod.GET})
    public ResponseEntity<Odontologo> buscarPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorNOmbre(nombre);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Buscar por nombre y apellido
    @RequestMapping(value = "/buscarPorapellido/{nombre}/{apellido}", method = {RequestMethod.GET})
    public ResponseEntity<Odontologo> buscarPorNombreYApellido(
            @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) throws Exception {
        Odontologo odontologo = odontologoService.buscarPorNombreYApellido(nombre, apellido);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    // 🔹 Listado completo
    @RequestMapping(value = "/listado", method = {RequestMethod.GET})
    public ResponseEntity<List<Odontologo>> listado() throws Exception {
        return new ResponseEntity<>(odontologoService.listado(), HttpStatus.OK);
    }

    // 🔹 Eliminar odontólogo
    @RequestMapping(value = "/eliminar/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable("id") int idodontologo) throws Exception {
        odontologoService.eliminarOdontologo(idodontologo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
