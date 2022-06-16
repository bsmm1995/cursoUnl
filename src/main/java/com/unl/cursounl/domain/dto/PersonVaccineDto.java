package com.unl.cursounl.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonVaccineDto {
  private Long id;
  private Long vaccineId;
  private Long personId;
  private Date date;
  private Integer dose;
}
