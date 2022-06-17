package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.VaccineDto;

import java.util.List;
/**
 * Gestionar CRUD de vacunas
 *
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public interface VaccineService {

  /**
   * Obtener una vacuna por su ID
   *
   * @param id ID del registro que se va a buscar
   * @return Vacuna encontrada
   */
  VaccineDto getById(long id);

  /**
   * Obtener todas las vacunas existentes
   *
   * @return Lista de vacunas
   */
  List<VaccineDto> getAll();

  /**
   * Crear una vacuna nueva
   *
   * @param data Objeto que contiene la información de la vacuna
   * @return Vacuna creada
   */
  VaccineDto create(VaccineDto data);

  /**
   * Actualizar un registro
   *
   * @param id ID de la vacuna que se va a actualizar
   * @param data Objeto que contiene la información de la vacuna
   * @return Vacuna actualizada
   */
  VaccineDto update(long id, VaccineDto data);

  /**
   * Eliminar una vacuna por su ID
   *
   * @param id ID del registro que se va a eliminar
   * @return ID del registro que se eliminó
   */
  long deleteById(long id);
}
