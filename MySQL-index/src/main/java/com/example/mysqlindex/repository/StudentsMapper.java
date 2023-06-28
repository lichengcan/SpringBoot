package com.example.mysqlindex.repository;

import com.example.mysqlindex.model.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author lichengcan
 */
public interface StudentsMapper extends JpaRepository<Students,Integer> {

}