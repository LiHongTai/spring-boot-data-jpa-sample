package com.roger.data.controller;

import com.roger.data.entity.Dept;
import com.roger.data.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//注解@RestController是 @Controller 和 @ResponseBody 注解的结合体
@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptRepository deptRepository;

    @GetMapping(value = "/{id}")
    public Dept findById(@PathVariable("id") Integer id){
        Dept dept = null;
        Optional<Dept> optionalDept = deptRepository.findById(id);
        if(optionalDept.isPresent()){
            dept = optionalDept.get();
        }
        return dept;
    }


    @GetMapping(value = "/create")
    public Dept create(){
        Dept dept = new Dept();
        dept.setDName("研发部");
        dept.setLocation("ShangHai");

        deptRepository.save(dept);
        return dept;
    }

    @GetMapping(value = "delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        deptRepository.deleteById(id);
    }

    @GetMapping(value = "update/{id}")
    public Dept update(@PathVariable("id") Integer id){
        Dept dept = null;
        Optional<Dept> optionalDept = deptRepository.findById(id);
        if(optionalDept.isPresent()){
            dept = optionalDept.get();
            dept.setLocation("AnHui");
            deptRepository.save(dept);
        }
        return dept;
    }
}
