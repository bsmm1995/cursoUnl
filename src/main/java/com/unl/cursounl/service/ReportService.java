package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.ReportDto;

import java.util.Date;
import java.util.List;

public interface ReportService {
  List<ReportDto> getByDateRange(Date startDate, Date endDate);
}
