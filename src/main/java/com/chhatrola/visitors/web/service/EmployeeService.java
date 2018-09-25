package com.chhatrola.visitors.web.service;

import com.chhatrola.visitors.web.model.Employee;
import com.chhatrola.visitors.web.model.RequestData;

public interface EmployeeService {
    Employee login(RequestData requestData);
}
