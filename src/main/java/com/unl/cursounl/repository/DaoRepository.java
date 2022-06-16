package com.unl.cursounl.repository;

import com.unl.cursounl.domain.Person;
import com.unl.cursounl.domain.dto.PersonDto;

import java.util.Date;
import java.util.List;

public interface DaoRepository {
  List<Person> findAll();

  List<Person> findAllCriteria();

  List<PersonDto> findAllCriteriaDto();

  List<Object[]> getReport(Date startDate, Date endDate);
}
