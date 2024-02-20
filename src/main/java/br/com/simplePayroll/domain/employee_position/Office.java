package br.com.simplePayroll.domain.employee_position;

import br.com.simplePayroll.domain.department.Department;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    private Double salary;

    public Office(String description, Department department, Double salary) {
        this.description = description;
        this.department = department;
        this.salary = salary;
    }

}