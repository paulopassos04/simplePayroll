package br.com.simplePayroll.controller;

import java.util.List;

import br.com.simplePayroll.domain.employee_position.Job;
import br.com.simplePayroll.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.simplePayroll.domain.employee.Employee;
import br.com.simplePayroll.service.interfaces.EmployeeService;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Operation(summary = "Recuperar um empregado pelo nome", description = "", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.findEmployeeByName(name);
        System.out.println(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<List<Employee>> findByJob(@PathVariable("id") Long id) {
        List<Employee> employees = employeeService.findByJobId(id);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> findByJob(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
