package com.chhatrola.visitors.web.controller.impl;

import com.chhatrola.visitors.web.model.Employee;
import com.chhatrola.visitors.web.model.RequestData;
import com.chhatrola.visitors.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> login(@RequestBody RequestData requestData) {
        Employee employee = employeeService.login(requestData);
        if(employee == null){
            return new ResponseEntity<Employee>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

}
