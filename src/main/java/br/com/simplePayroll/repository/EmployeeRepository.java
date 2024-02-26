package br.com.simplePayroll.repository;

import br.com.simplePayroll.domain.employee.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN e.job WHERE e.name LIKE %:name%")
    public List<Employee> findEmployeeByName(@Param("name") String name);



}
