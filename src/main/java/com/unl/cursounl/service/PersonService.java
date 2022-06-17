package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.PersonDto;

import java.util.List;

/**
 * Gestionar CRUD de personas
 *
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public interface PersonService {

  /**
   * Obtener un registro por ID
   *
   * @param id ID del registro que se va a buscar
   * @return Persona encontrada
   */
  PersonDto getById(long id);

  /**
   * Obtener todas las personas existentes
   *
   * @return Lista de personas
   */
  List<PersonDto> getAll();

  /**
   * Crear una persona nueva
   *
   * @param data Objeto que contiene la información de la persona
   * @return Persona creada
   */
  PersonDto create(PersonDto data);

  /**
   * Actualizar un registro
   *
   * @param id ID de la persona que se va a actualizar
   * @param data Objeto que contiene la información de la persona
   * @return Persona actualizada
   */
  PersonDto update(long id, PersonDto data);

  /**
   * Eliminar una persona por su ID
   *
   * @param id ID del registro que se va a eliminar
   * @return ID del registro que se eliminó
   */
  long deleteById(long id);
}
