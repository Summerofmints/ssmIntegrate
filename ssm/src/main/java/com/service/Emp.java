package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;

import java.util.List;

public interface Emp {
    List<Employee> getAllEmp();

    PageInfo<Employee> getPageInfo(Integer pageMum);

    void addEmp(Employee employee);

    void delete(Integer empId);


    Employee getEmp(Integer empId);

    void update(Employee employee);
}
