package com.example.mysqlindex.controller;

import com.example.mysqlindex.repository.StudentsMapper;
import com.example.mysqlindex.model.entity.Students;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author: lichengcan
 * @date: 2023-06-28 21:15
 * @description
 **/
@RequestMapping("/api")
@RestController
public class StudentController {
    private static final String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Taylor", "Miller", "Wilson"};
    private static final String[] GENDERS = {"Male", "Female"};

    @Autowired
    StudentsMapper studentsMapper;

    @PostMapping("/students")
    public void createStudent() {
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Students students = new Students();
            students.setAge(generateRandomAge());
            students.setName(generateRandomName());
            students.setTel(generateRandomPhoneNumber());
            students.setGrade(generateRandomAge());
            studentsList.add(students);
        }
        studentsMapper.saveAllAndFlush(studentsList);
    }

    @GetMapping("/students")
    public List<Students> getStudent(String name) {
        long startTime = System.currentTimeMillis();
        Students Students = new Students();
        Students.setName(name);
        //模糊查询匹配开头，即{name}%
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Students> example = Example.of(Students ,matcher);
        List<Students> list = studentsMapper.findAll(example);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("方法执行耗时: " + duration + " 毫秒");
        return list;
    }

    private static String generateRandomName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    private static String generateRandomGender() {
        Random random = new Random();
        return GENDERS[random.nextInt(GENDERS.length)];
    }

    private static int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(60) + 18; // Generate age between 18 and 77
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        // Generate area code
        phoneNumber.append(String.format("%03d", random.nextInt(1000)));
        phoneNumber.append("-");

        // Generate phone number prefix
        phoneNumber.append(String.format("%03d", random.nextInt(1000)));
        phoneNumber.append("-");

        // Generate phone number line
        phoneNumber.append(String.format("%04d", random.nextInt(10000)));

        return phoneNumber.toString();
    }
}
