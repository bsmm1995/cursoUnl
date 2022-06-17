package com.unl.cursounl.service;

import com.unl.cursounl.domain.dto.ReportDto;

import java.util.Date;
import java.util.List;
/**
 * @author: User Lastname <username@email.com>
 * @version: 17/06/2022
 */
public interface ReportService {
  List<ReportDto> getByDateRange(Date startDate, Date endDate);
}
