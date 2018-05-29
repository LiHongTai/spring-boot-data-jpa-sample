package com.roger.data.controller;

import com.roger.data.entity.Emp;
import com.roger.data.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @GetMapping(value = "/{id}")
    public Emp findById(@PathVariable("id") Integer id) {
        Emp emp = null;
        Optional<Emp> empOptional = empRepository.findById(id);
        if(empOptional.isPresent()){
            emp = empOptional.get();
        }
        return emp;
    }
}
