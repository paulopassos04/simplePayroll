package br.com.simplePayroll.domain.employee;

import java.time.LocalDate;
import br.com.simplePayroll.domain.employee_position.Job;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Job job;

    public Employee(String name, LocalDate startDate, Job job) {
        this.name = name;
        this.startDate = startDate;
        this.job= job;
    }

}
