package com.example.examenisaac.model.dao;

import com.example.examenisaac.model.entity.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer> {
}
