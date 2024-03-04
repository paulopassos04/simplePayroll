package br.com.simplePayroll.service;

import java.util.List;
import java.util.Optional;

import br.com.simplePayroll.service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.simplePayroll.domain.employee.Employee;
import br.com.simplePayroll.repository.EmployeeRepository;
import br.com.simplePayroll.service.interfaces.EmployeeService;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> findEmployeeByName(String name) {
            List<Employee> employees = employeeRepository.findEmployeeByName(name);

            if (employees.isEmpty()){
                throw new EmployeeNotFoundException(String.format("Funcionário(a) %s não encontrado(a).", name));
            }

            return employees;
    }

    @Override
    public List<Employee> findByJobId(Long id) {
        return employeeRepository.findJobsWithEmployeesById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format("Funcionário(a) ID %d não encontrado(a).", id)));
        return Optional.ofNullable(employee);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Employee employeeBody) {
        Optional<Employee> employeeOptional = findById(id);

            Employee employee = employeeOptional.get();
            employee.setName(employeeBody.getName());
            employee.setJob(employeeBody.getJob());

            employeeRepository.save(employee);

    }

}
