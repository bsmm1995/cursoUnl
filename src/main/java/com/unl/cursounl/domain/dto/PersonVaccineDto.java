package com.unl.cursounl.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
public class PersonVaccineDto {
  private Long id;

  @NotNull(message = "EL ID de la vacuna no puede ser nulo.")
  @Min(value = 1, message = "El ID de la vacuna no puede ser menor que cero.")
  private Long vaccineId;

  @NotNull(message = "EL ID de la persona no puede ser nulo.")
  @Min(value = 1, message = "El ID de la persona no puede ser menor que cero.")
  private Long personId;

  @PastOrPresent(message = "La fecha no debe ser mayor a la fecha actual")
  private Date date;

  @Range(min = 1, max = 4, message = "El número de dosis no puede ser menor que 1 ni mayor que 4.")
  private Integer dose;
}
