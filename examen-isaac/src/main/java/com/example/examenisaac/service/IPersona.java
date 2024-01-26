package com.example.examenisaac.service;

import com.example.examenisaac.model.dto.PersonaDto;
import com.example.examenisaac.model.entity.PersonaBean;

import java.util.List;

public interface IPersona {

    PersonaBean save(PersonaDto persona);

    PersonaBean findById(Integer id);

    List<PersonaBean> findAll();

    void delete(PersonaBean persona);
}
