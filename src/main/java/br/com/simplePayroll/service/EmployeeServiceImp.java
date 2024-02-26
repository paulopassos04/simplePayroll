package br.com.simplePayroll.service;

import java.util.List;
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
    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public Employee findByJob(Long id) {
        // TODO Auto-generated method stub
        return null;
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
