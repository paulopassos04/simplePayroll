package br.com.simplePayroll.controller;

import java.util.List;
import br.com.simplePayroll.domain.employee_position.Job;
import br.com.simplePayroll.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.simplePayroll.domain.employee.Employee;
import br.com.simplePayroll.service.interfaces.EmployeeService;

@Tag(name = "Empregado", description = "Contem todas as operações do empregado CRUD")
@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Cadastro do funcionário", description = "Cadastro do funcionário na base de dados", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso criado com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "", description = "", content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employeeBody){
        Employee employee = employeeService.createEmployee(employeeBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @Operation(summary = "Busca por nome", description = "Busca do funcionário da base de dados usando o nome", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Funcionário(a) não encontrado(a)", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.findEmployeeByName(name);
        System.out.println(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @Operation(summary = "Listar funcionários", description = "Listar funcionários da base de dados usando por cargo", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/job/{id}")
    public ResponseEntity<List<Employee>> findByJob(@PathVariable("id") Long id) {
        List<Employee> employees = employeeService.findByJobId(id);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @Operation(summary = "Atualizar funcionário", description = "Atualizar funcionário da base de dados", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Funcionário(a) não encontrado(a)", content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Deletar funcionário", description = "Deletar funcionário da base de dados", responses = {
            @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Funcionário(a) não encontrado(a)", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
