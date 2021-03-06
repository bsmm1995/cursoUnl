package com.unl.cursounl.service.impl;

import com.unl.cursounl.domain.dto.ReportDto;
import com.unl.cursounl.repository.DaoRepository;
import com.unl.cursounl.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** {@inheritDoc} */
@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
  private final DaoRepository daoRepository;

  /** {@inheritDoc} */
  @Override
  public List<ReportDto> getByDateRange(Date startDate, Date endDate) {
    List<Object[]> objects = this.daoRepository.getReport(startDate, endDate);
    List<ReportDto> reportDtos = new ArrayList<>(0);
    for (Object[] object : objects) {
      reportDtos.add(new ReportDto(object));
    }
    return reportDtos;
  }
}
