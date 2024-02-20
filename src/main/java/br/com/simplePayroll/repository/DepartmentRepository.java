package br.com.simplePayroll.repository;

import br.com.simplePayroll.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
