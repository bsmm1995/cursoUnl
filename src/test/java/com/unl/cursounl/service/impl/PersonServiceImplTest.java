package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.Person;
import com.unl.cursounl.domain.dto.PersonDto;
import com.unl.cursounl.repository.PersonRepository;
import com.unl.cursounl.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

  private PersonService personService;
  private PersonRepository personRepositoryMock;

  @BeforeEach
  void setUp() {
    this.personRepositoryMock = Mockito.mock(PersonRepository.class);
    this.personService = new PersonServiceImpl(this.personRepositoryMock);
  }

  @Test
  void getById() {
    long id = 1;
    Person personEntity = new Person();
    personEntity.setId(id);
    personEntity.setName("Bladimir");

    Mockito.when(this.personRepositoryMock.findById(id)).thenReturn(Optional.of(personEntity));
    PersonDto dto = this.personService.getById(id);

    assertNotNull(dto);
    assertEquals(1, dto.getId());
  }
}
