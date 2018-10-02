package com.chhatrola.visitors.web.controller.impl;

import com.chhatrola.visitors.web.model.RequestData;
import com.chhatrola.visitors.web.model.ResponseData;
import com.chhatrola.visitors.web.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
@Api(value="Authoriser", description="Authoriser operation")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseData> login(@RequestBody RequestData requestData) throws JsonProcessingException {
        return employeeService.login(requestData);
    }

}
