package br.com.simplePayroll.repository;

import br.com.simplePayroll.domain.employee_position.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
