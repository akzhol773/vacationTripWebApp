package com.neobis.vacationtrip.repositories;

import com.neobis.vacationtrip.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional<Employee> findByEmail(String email);
}
