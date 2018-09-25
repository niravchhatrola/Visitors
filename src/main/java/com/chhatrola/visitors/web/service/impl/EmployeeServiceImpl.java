package com.chhatrola.visitors.web.service.impl;

import com.chhatrola.visitors.web.model.Employee;
import com.chhatrola.visitors.web.model.RequestData;
import com.chhatrola.visitors.web.repository.EmployeeRepository;
import com.chhatrola.visitors.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee login(RequestData requestData){
        List<Employee> employeeList = employeeRepository.findByUserNameAndBranch_BranchCode(requestData.getUserName(), requestData.getBranchCode());
        if(employeeList==null || employeeList.isEmpty()){
            return null;
        }
        return employeeList.get(0);
    }
}
