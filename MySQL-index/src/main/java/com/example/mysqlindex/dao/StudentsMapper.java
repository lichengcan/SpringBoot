package com.example.mysqlindex.dao;

import com.example.mysqlindex.model.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author lichengcan
 */
public interface StudentsMapper extends JpaRepository<Students,Integer> {

}