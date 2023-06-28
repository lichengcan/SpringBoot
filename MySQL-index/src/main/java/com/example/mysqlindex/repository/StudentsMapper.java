package com.example.mysqlindex.repository;

import com.example.mysqlindex.model.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author lichengcan
 */
public interface StudentsMapper extends JpaRepository<Students,Integer> {

    @Query("select s.name,s.age,s.grade,s.tel from Students as s where s.name =?1")
    List<Students> findByName(String name);
}