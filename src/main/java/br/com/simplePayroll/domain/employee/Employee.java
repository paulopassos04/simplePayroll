package br.com.simplePayroll.domain.employee;

import java.time.LocalDate;

import br.com.simplePayroll.domain.employee_position.Office;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate startDate;

    @ManyToOne
    private Office office;

    public Employee(String name, LocalDate startDate, Office office) {
        this.name = name;
        this.startDate = startDate;
        this.office = office;
    }

}
