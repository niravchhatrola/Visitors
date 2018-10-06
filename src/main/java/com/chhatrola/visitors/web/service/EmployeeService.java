package com.chhatrola.visitors.web.service;

import com.chhatrola.visitors.util.GeneratorUtil;
import com.chhatrola.visitors.util.ResponseUtil;
import com.chhatrola.visitors.web.model.*;
import com.chhatrola.visitors.web.repository.BranchRepository;
import com.chhatrola.visitors.web.repository.ContractorVisitRepository;
import com.chhatrola.visitors.web.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    ContractorVisitRepository contractorVisitRepository;

    public ResponseEntity<Response> login(RequestData requestData) throws JsonProcessingException {

        List<Employee> employeeList = employeeRepository.findByUserName(requestData.getUserName());
        if (employeeList == null || employeeList.isEmpty()) {
            return ResponseUtil.prepareResponse(ResponseStatus.INVALID_USER, "");
        }
        Employee employee = employeeList.get(0);
        boolean isBranchExists = branchRepository.existsByBranchCode(requestData.getBranchCode());
        if (!isBranchExists) {
            return ResponseUtil.prepareResponse(ResponseStatus.INVALID_BRANCH, "");
        }
        String authToken = GeneratorUtil.generateUuid();
        employee.setEmpAuthToken(authToken);
        employeeRepository.save(employee);
        List<String> branchList = contractorVisitRepository.findBranchByEmployee_EmployeeId(1l);
        ResponseData responseData = new ResponseData();
        responseData.setBranchCodeList(branchList);
        responseData.setAuthToken(authToken);
        responseData.setEmployeeId(employee.getEmployeeId());
        return ResponseUtil.prepareResponse(ResponseStatus.LOGIN_SUCCESSFULL, responseData);
    }

    public ResponseEntity<Response> logout(RequestData requestData) throws JsonProcessingException {
        Employee employee = employeeRepository.getOne(requestData.getEmpId());
        employee.setEmpAuthToken(null);
        employeeRepository.save(employee);
        return ResponseUtil.prepareResponse(ResponseStatus.LOGOUT_SUCCESSFULL, "");
    }


}