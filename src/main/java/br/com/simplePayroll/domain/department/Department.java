package br.com.simplePayroll.domain.department;

import br.com.simplePayroll.domain.employee_position.Office;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices = new HashSet<>();

    public Department(String description) {
        this.description = description;
    }

    public void addOffice(Office office) {
        offices.add(office);
        office.setDepartment(this);
    }

    public void removeOffice(Office office) {
        offices.remove(office);
        office.setDepartment(null);
    }

}