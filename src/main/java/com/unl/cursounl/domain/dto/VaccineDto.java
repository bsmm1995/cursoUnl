package com.unl.cursounl.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VaccineDto {
  private Long id;

  @NotEmpty(message = "En nombre de la vacuna no puede ser nulo ni vacío.")
  private String name;

  @NotEmpty(message = "En lote de la vacuna no puede ser nulo ni vacío.")
  private String lot;
}
