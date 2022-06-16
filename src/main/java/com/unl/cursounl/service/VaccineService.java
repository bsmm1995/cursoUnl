package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.VaccineDto;

import java.util.List;

public interface VaccineService {
  VaccineDto getById(long id);

  List<VaccineDto> getAll();

  VaccineDto create(VaccineDto data);

  VaccineDto update(long id, VaccineDto data);

  long deleteById(long id);
}
