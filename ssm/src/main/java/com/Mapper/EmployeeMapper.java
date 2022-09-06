package com.Mapper;

import com.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmp();

    void addEmp(Employee employee);

    void delete(Integer empId);

    Employee getEmp(Integer empId);

    void update(Employee employee);
}
