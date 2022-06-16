package com.unl.cursounl.repository;

import com.unl.cursounl.domain.PersonVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonVaccineRepository extends JpaRepository<PersonVaccine, Long> {}
