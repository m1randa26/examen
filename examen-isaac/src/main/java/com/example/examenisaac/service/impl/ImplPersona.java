package com.example.examenisaac.service.impl;

import com.example.examenisaac.model.dao.PersonaDao;
import com.example.examenisaac.model.dto.PersonaDto;
import com.example.examenisaac.model.entity.PersonaBean;
import com.example.examenisaac.service.IPersona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ImplPersona implements IPersona {

    private final PersonaDao personaDao;


    @Transactional
    @Override
    public PersonaBean save(PersonaDto persona) {
        StringBuilder curp = new StringBuilder();
        String primerApellido = persona.getPrimerApellido().toUpperCase();
        String segundoApellido = persona.getSegundoApellido().toUpperCase();
        String nombre = persona.getNombre().toUpperCase();
        curp.append(primerApellido.toCharArray()[0]);

        if (primerApellido.toCharArray()[0] == 'A' || primerApellido.toCharArray()[0] == 'E' ||
            primerApellido.toCharArray()[0] == 'I' || primerApellido.toCharArray()[0] == 'O' ||
            primerApellido.toCharArray()[0] == 'U') {
            for (int i = 1; i < primerApellido.length(); i++) {
                if (primerApellido.charAt(i) == 'A' || primerApellido.charAt(i) == 'E' ||
                    primerApellido.charAt(i) == 'I' || primerApellido.charAt(i) == 'O' ||
                    primerApellido.charAt(i) == 'U') {
                    curp.append(primerApellido.charAt(i));
                    break;
                }
            }
        } else {
            for (char letra: primerApellido.toCharArray()) {
                if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
                    curp.append(letra);
                    break;
                }
            }
        }

        // FECHA NACIMIENTO
        curp.append(segundoApellido.toCharArray()[0]);
        curp.append(persona.getNombre().toCharArray()[0]);
        curp.append(persona.getFechaNacimiento().toCharArray()[persona.getFechaNacimiento().length() - 2]);
        curp.append(persona.getFechaNacimiento().toCharArray()[persona.getFechaNacimiento().length() - 1]);
        curp.append(persona.getFechaNacimiento().toCharArray()[persona.getFechaNacimiento().length() - 7]);
        curp.append(persona.getFechaNacimiento().toCharArray()[persona.getFechaNacimiento().length() - 6]);
        curp.append(persona.getFechaNacimiento().toCharArray()[0]);
        curp.append(persona.getFechaNacimiento().toCharArray()[1]);

        // SEXO
        curp.append(persona.getSexo().toUpperCase().toCharArray()[0]);
        curp.append(persona.getEstadoNacimiento().toUpperCase());

        // SEGUNDO APELLIDO
        for (int i = 1; i < segundoApellido.length(); i++) {
            if (segundoApellido.toCharArray()[i] != 'A' && segundoApellido.toCharArray()[i] != 'E'
                && segundoApellido.toCharArray()[i] != 'I' && segundoApellido.toCharArray()[i] != 'O'
                && segundoApellido.toCharArray()[i] != 'U') {
                curp.append(segundoApellido.toCharArray()[i]);
                break;
            }
        }

        // Nombre
        for (int i = 1; i < nombre.length(); i++) {
            if (nombre.toCharArray()[i] != 'A' && nombre.toCharArray()[i] != 'E'
                    && nombre.toCharArray()[i] != 'I' && nombre.toCharArray()[i] != 'O'
                    && nombre.toCharArray()[i] != 'U') {
                curp.append(nombre.toCharArray()[i]);
                break;
            }
        }

        // DIGITOS ALEATORIOS
        Random random = new Random();
        curp.append(random.nextInt(1, 10));
        curp.append(random.nextInt(1, 10));

        PersonaBean save = PersonaBean.builder()
                .idPerson(persona.getId_persona())
                .nombre(persona.getNombre())
                .primerApellido(persona.getPrimerApellido())
                .segundoApellido(persona.getSegundoApellido())
                .estadoNacimiento(persona.getEstadoNacimiento())
                .fechaNacimiento(persona.getFechaNacimiento())
                .sexo(persona.getSexo())
                .curp(curp.toString())
                .build();
        return personaDao.save(save);
    }

    @Transactional(readOnly = true)
    @Override
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();
    }

    @Transactional
    @Override
    public void delete(PersonaBean persona) {
        personaDao.delete(persona);
    }
}
