package com.roger.data.controller;

import com.roger.data.entity.Dept;
import com.roger.data.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

}
