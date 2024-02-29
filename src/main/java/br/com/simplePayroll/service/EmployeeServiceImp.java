package br.com.simplePayroll.service;

import java.util.List;

import br.com.simplePayroll.domain.employee_position.Job;
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
    public List<Employee> findByJob(Long id) {
        return employeeRepository.findJobsWithEmployeesById(id);
    }

    @Override
    public Employee findByDepartment(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Long id) {
        // TODO Auto-generated method stub

    }

}
