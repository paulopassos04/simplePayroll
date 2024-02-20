package br.com.simplePayroll.repository;

import br.com.simplePayroll.domain.department.Department;
import br.com.simplePayroll.domain.employee.Employee;
import br.com.simplePayroll.domain.employee_position.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestJpa implements CommandLineRunner {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department("Vendas");

        Office office1 = new Office("Vendendor", department1, 3000.0);

        Employee employee1 = new Employee("Paulo", LocalDate.now(), office1);
        Employee employee2 = new Employee("Jose", LocalDate.now(), office1);
        Employee employee3 = new Employee("Luiz", LocalDate.now(), office1);

        departmentRepository.saveAll(Arrays.asList(department1));
        officeRepository.saveAll(Arrays.asList(office1));
        employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));

    }
}
