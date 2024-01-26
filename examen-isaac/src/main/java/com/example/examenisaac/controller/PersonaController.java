package com.example.examenisaac.controller;

import com.example.examenisaac.model.dto.PersonaDto;
import com.example.examenisaac.model.entity.PersonaBean;
import com.example.examenisaac.service.impl.ImplPersona;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonaController {

    private final ImplPersona service;

    @GetMapping("/persona")
    public List<PersonaBean> getPersona() {
        return service.findAll();
    }

    @GetMapping("/persona/{id}")
    public PersonaBean showById(@PathVariable Integer id) {
        try {
            return service.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en BD", dae);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener registro: ", e);
        }
    }

    @PutMapping("/persona")
    public PersonaDto update(@RequestBody PersonaDto personaDto) {
        PersonaBean personaUpdate = service.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaUpdate.getIdPerson())
                .nombre(personaUpdate.getNombre())
                .primerApellido(personaUpdate.getPrimerApellido())
                .segundoApellido(personaUpdate.getSegundoApellido())
                .fechaNacimiento(personaUpdate.getFechaNacimiento())
                .estadoNacimiento(personaUpdate.getEstadoNacimiento())
                .sexo(personaUpdate.getSexo())
                .build();
    }

    @DeleteMapping("/persona/{id}")
    public void delete(@PathVariable Integer id) {
        PersonaBean persona = service.findById(id);
        service.delete(persona);
    }

    @PostMapping("/persona")
    public PersonaDto create(@RequestBody PersonaDto personaDto) {
        PersonaBean personaSave = service.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaSave.getIdPerson())
                .nombre(personaSave.getNombre())
                .primerApellido(personaSave.getPrimerApellido())
                .segundoApellido(personaSave.getSegundoApellido())
                .fechaNacimiento(personaSave.getFechaNacimiento())
                .estadoNacimiento(personaSave.getEstadoNacimiento())
                .sexo(personaSave.getSexo())
                .curp(personaSave.getCurp())
                .build();
    }
}
