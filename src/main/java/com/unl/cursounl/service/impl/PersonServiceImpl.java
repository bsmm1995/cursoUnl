package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.Person;
import com.unl.cursounl.repository.PersonRepository;
import com.unl.cursounl.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
  private final PersonRepository personRepository;

  @Override
  public Person getById(long id) {
    Optional<Person> person = this.personRepository.findById(id);
    return person.get();
  }
}
