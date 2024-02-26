package br.com.simplePayroll.service.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.simplePayroll.domain.employee.Employee;

@Service
public interface EmployeeService {

    public List<Employee> findEmployeeByName(String name);

    public Employee findByJob(Long id);

    public Employee findByDepartment(Long id);

    public Employee findById(Long id);

    public void delete(Long id);

    public void update(Long id);

}