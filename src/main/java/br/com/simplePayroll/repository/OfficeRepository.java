package br.com.simplePayroll.repository;

import br.com.simplePayroll.domain.employee_position.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
