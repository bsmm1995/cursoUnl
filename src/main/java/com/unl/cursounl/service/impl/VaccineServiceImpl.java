package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.Vaccine;
import com.unl.cursounl.domain.dto.VaccineDto;
import com.unl.cursounl.exceptions.CustomNotFoundException;
import com.unl.cursounl.repository.VaccineRepository;
import com.unl.cursounl.service.VaccineService;
import com.unl.cursounl.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** {@inheritDoc} */
@Service
@AllArgsConstructor
public class VaccineServiceImpl implements VaccineService {
  private final VaccineRepository vaccineRepository;

  /** {@inheritDoc} */
  @Override
  public VaccineDto getById(long id) {
    Vaccine vaccine = getEntityById(id);
    return convertEntityToDto(vaccine);
  }

  /** {@inheritDoc} */
  @Override
  public List<VaccineDto> getAll() {
    List<Vaccine> vaccines = this.vaccineRepository.findAll();
    return vaccines.stream().map(this::convertEntityToDto).toList();
  }

  /** {@inheritDoc} */
  @Override
  public VaccineDto create(VaccineDto data) {
    Vaccine vaccine = convertDtoToEntity(data);
    return convertEntityToDto(this.vaccineRepository.save(vaccine));
  }

  /** {@inheritDoc} */
  @Override
  public VaccineDto update(long id, VaccineDto data) {
    Vaccine vaccine = getEntityById(id);
    vaccine.setName(data.getName());
    vaccine.setLot(data.getLot());
    return convertEntityToDto(this.vaccineRepository.save(vaccine));
  }

  /** {@inheritDoc} */
  @Override
  public long deleteById(long id) {
    getEntityById(id);
    this.vaccineRepository.deleteById(id);
    return id;
  }

  private Vaccine getEntityById(long id) {
    Optional<Vaccine> optional = this.vaccineRepository.findById(id);
    if (optional.isEmpty()) {
      throw new CustomNotFoundException("No se encontró el registro con el id " + id);
    }
    return optional.get();
  }

  private VaccineDto convertEntityToDto(Vaccine entity) {
    return Mapper.modelMapper().map(entity, VaccineDto.class);
  }

  private Vaccine convertDtoToEntity(VaccineDto entity) {
    return Mapper.modelMapper().map(entity, Vaccine.class);
  }
}
