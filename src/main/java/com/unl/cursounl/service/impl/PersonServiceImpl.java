package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.Person;
import com.unl.cursounl.domain.dto.PersonDto;
import com.unl.cursounl.repository.PersonRepository;
import com.unl.cursounl.service.PersonService;
import com.unl.cursounl.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
  private final PersonRepository personRepository;

  @Override
  public PersonDto getById(long id) {
    return convertEntityToDto(getEntityById(id));
  }

  /** {@inheritDoc} */
  @Override
  public List<PersonDto> getAll() {
    return this.personRepository.findAll().stream().map(this::convertEntityToDto).toList();
  }

  @Override
  public PersonDto create(PersonDto data) {
    Person person = convertDtoToEntity(data);
    return convertEntityToDto(this.personRepository.save(person));
  }

  @Override
  public PersonDto update(long id, PersonDto data) {
    Person person = getEntityById(id);
    person.setName(data.getName());
    person.setLastname(data.getLastname());
    return convertEntityToDto(this.personRepository.save(person));
  }

  @Override
  public long deleteById(long id) {
    getEntityById(id);
    this.personRepository.deleteById(id);
    return id;
  }

  private Person getEntityById(long id) {
    Optional<Person> optional = this.personRepository.findById(id);
    if (optional.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "No se encontró un registro con el id " + id);
    }
    return optional.get();
  }

  private PersonDto convertEntityToDto(Person entity) {
    return Mapper.modelMapper().map(entity, PersonDto.class);
  }

  private Person convertDtoToEntity(PersonDto entity) {
    return Mapper.modelMapper().map(entity, Person.class);
  }
}
