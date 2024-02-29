package br.com.simplePayroll.domain.employee_position;

import br.com.simplePayroll.domain.department.Department;
import br.com.simplePayroll.domain.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new HashSet<>();

    private Double salary;

    public Job(String description, Department department, Double salary) {
        this.description = description;
        this.department = department;
        this.salary = salary;
    }

}