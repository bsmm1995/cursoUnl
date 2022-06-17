package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.PersonVaccineDto;

import java.util.List;
/**
 * Gestionar proceso de vacunas
 *
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public interface PersonVaccineService {

  /**
   * Obtener un registro por ID
   *
   * @param id ID del registro que se va a buscar
   * @return PersonVaccine encontrada
   */
  PersonVaccineDto getById(long id);

  /**
   * Obtener todas las personVaccines existentes
   *
   * @return Lista de personVaccines
   */
  List<PersonVaccineDto> getAll();

  /**
   * Crear una personVaccine nueva
   *
   * @param data Objeto que contiene la información de la personVaccine
   * @return PersonVaccine creada
   */
  PersonVaccineDto create(PersonVaccineDto data);

  /**
   * Actualizar un registro
   *
   * @param id ID de la personVaccine que se va a actualizar
   * @param data Objeto que contiene la información de la personVaccine
   * @return PersonVaccine actualizada
   */
  PersonVaccineDto update(long id, PersonVaccineDto data);

  /**
   * Eliminar una personVaccine por su ID
   *
   * @param id ID del registro que se va a eliminar
   * @return ID del registro que se eliminó
   */
  long deleteById(long id);
}
