package br.com.simplePayroll.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.com.simplePayroll.domain.employee.Employee;

@Service
public interface EmployeeService {

    public List<Employee> findEmployeeByName(String name);

    public List<Employee> findByJobId(Long id);

    public Optional<Employee> findById(Long id);

    public void delete(Long id);

    public void update(Long id, Employee employeeBody);

}
