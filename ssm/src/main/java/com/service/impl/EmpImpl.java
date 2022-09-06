package com.service.impl;

import com.Mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import com.service.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpImpl implements Emp {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmp() {
        return employeeMapper.getAllEmp();
    }

    public PageInfo getPageInfo(Integer pageMum) {
        PageHelper.startPage(pageMum,5);
        List<Employee> list = employeeMapper.getAllEmp();
        PageInfo<Employee> page  = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
    }

    @Override
    public void delete(Integer empId) {
        employeeMapper.delete(empId);
    }

    @Override
    public Employee getEmp(Integer empId) {
        return employeeMapper.getEmp(empId);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }
}
