package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.PersonDto;

import java.util.List;

public interface PersonService {
  PersonDto getById(long id);

  /**
   * Obtener todas las personas existentes
   *
   * @return Lista de personas
   */
  List<PersonDto> getAll();

  PersonDto create(PersonDto data);

  PersonDto update(long id, PersonDto data);

  long deleteById(long id);
}
