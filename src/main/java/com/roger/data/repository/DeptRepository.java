package com.roger.data.repository;

import com.roger.data.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Integer> {

    //JPQL 持久化查询语句 -- 类SQL语句
    //从SQL语句转换成JPQL语句，只需要注意一下几点
    //1. 大多数情况下，* 替换成 别名
    //2. 所有出现表名的地方替换成实体类名
    //3. 所有列名替换成属性名
    //4. 参数传递 --> :dName 配合注解 @Param 使用
}
