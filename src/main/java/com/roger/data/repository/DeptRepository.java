package com.roger.data.repository;

import com.roger.data.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Integer> {

}
