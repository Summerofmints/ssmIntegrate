package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import com.service.impl.EmpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//        查询所有的员工信息-->/ employee-->get
//        查询所有的员工分页信息-->/ employee/page/1-->get
//        根据id查询员工信息-->/employee/1-->get
//        跳转到添加页面-->/to/ add-->get
//        添加员工信息-->/ employee-->post
//        修改员工信息-->/ empLoyee-->put
//        删除员工信息-->/ employee/1-->delete

@Controller
@Transactional
public class EmployeeController {
    @Autowired
    EmpImpl empService;

    @RequestMapping(value = "/get/all/page/{pageNum}",method = RequestMethod.GET)
    public String getAllEmpPage(Model model,@PathVariable("pageNum") Integer pageMum){
        PageInfo<Employee> page = empService.getPageInfo(pageMum);
        model.addAttribute("page",page);
        System.out.println("-------------"+page);
        return "EmployeeList";
    }

    @RequestMapping(value = "/get/all",method = RequestMethod.GET)
    public String getAllEmp(Model model){
        List<Employee> list = empService.getAllEmp();
        model.addAttribute("list", list);
        System.out.println("查询数据为："+list);
        return "EmployeeList";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String add(Employee employee,Model model){
        empService.addEmp(employee);
        return "redirect:/get/all/page/1";
    }
    @RequestMapping(value = "/to/delete/{empId}",method =  RequestMethod.GET)
    public String add(@PathVariable("empId") Integer empId){
        empService.delete(empId);
        return "redirect:/get/all/page/1";
    }

    //进行修改渲染
    @RequestMapping(value = "/to/update/{empId}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("empId") Integer empId,Model model){
       Employee employee=empService.getEmp(empId);
        model.addAttribute("Employee",employee);
        System.out.println(employee);
        return "EmployeeUpdate";
    }
    @RequestMapping(value = "/to/toupdate",method =  RequestMethod.POST)
    public String update(Employee employee){
        empService.update(employee);
        return "redirect:/get/all/page/1";
    }
}
