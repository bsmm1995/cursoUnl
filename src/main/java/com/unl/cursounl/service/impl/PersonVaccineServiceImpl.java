package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.PersonVaccine;
import com.unl.cursounl.domain.dto.PersonVaccineDto;
import com.unl.cursounl.exceptions.CustomNotFoundException;
import com.unl.cursounl.repository.PersonVaccineRepository;
import com.unl.cursounl.service.PersonVaccineService;
import com.unl.cursounl.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** {@inheritDoc} */
@Service
@AllArgsConstructor
public class PersonVaccineServiceImpl implements PersonVaccineService {
  private final PersonVaccineRepository personVaccineRepository;

  /** {@inheritDoc} */
  @Override
  public PersonVaccineDto getById(long id) {
    PersonVaccine personVaccine = getEntityById(id);
    return convertEntityToDto(personVaccine);
  }

  /** {@inheritDoc} */
  @Override
  public List<PersonVaccineDto> getAll() {
    List<PersonVaccine> personVaccines = this.personVaccineRepository.findAll();
    return personVaccines.stream().map(this::convertEntityToDto).toList();
  }

  /** {@inheritDoc} */
  @Override
  public PersonVaccineDto create(PersonVaccineDto data) {
    PersonVaccine personVaccine = convertDtoToEntity(data);
    return convertEntityToDto(this.personVaccineRepository.save(personVaccine));
  }

  /** {@inheritDoc} */
  @Override
  public PersonVaccineDto update(long id, PersonVaccineDto data) {
    PersonVaccine personVaccine = getEntityById(id);
    personVaccine.setPersonId(data.getPersonId());
    personVaccine.setVaccineId(data.getVaccineId());
    personVaccine.setDate(data.getDate());
    personVaccine.setDose(data.getDose());
    return convertEntityToDto(this.personVaccineRepository.save(personVaccine));
  }

  /** {@inheritDoc} */
  @Override
  public long deleteById(long id) {
    getById(id);
    this.personVaccineRepository.deleteById(id);
    return id;
  }

  private PersonVaccine getEntityById(long id) {
    Optional<PersonVaccine> optional = this.personVaccineRepository.findById(id);
    if (optional.isEmpty()) {
      throw new CustomNotFoundException("No se encontró el registro con el id " + id);
    }
    return optional.get();
  }

  private PersonVaccineDto convertEntityToDto(PersonVaccine entity) {
    return Mapper.modelMapper().map(entity, PersonVaccineDto.class);
  }

  private PersonVaccine convertDtoToEntity(PersonVaccineDto entity) {
    return Mapper.modelMapper().map(entity, PersonVaccine.class);
  }
}
