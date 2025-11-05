package com.proyecto.odontologo.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.odontologo.entidades.Odontologo;
import com.proyecto.odontologo.repository.OdontologoRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initOdontologos(OdontologoRepository odontologoRepository) {
        return args -> {
            if (odontologoRepository.count() == 0) {
                System.out.println("🦷 Creando odontólogos iniciales...");

                Odontologo o1 = new Odontologo("Carlos", "Lopez", "20000002", "Ortodoncia", "MAT1234", "9876543212", "odontologo@clinicadental.com", LocalDate.now());

                odontologoRepository.save(o1);

                System.out.println("Odontólogos creados exitosamente");
            }
        };
    }
}