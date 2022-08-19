package org.example.service.Impl;

import org.example.entity.student;
import org.example.mapper.*;
import org.example.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper studentsMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    public void getStudent(){
        System.out.println("service成功注入");
        List<student> result=studentsMapper.findAll();
    }
    public void insertStudent(){
        student aStudent=new student();
        aStudent.setId(0);
        System.out.println("注入insertStudent");
        studentsMapper.insertStudent(aStudent);
    }
    public void redisTest(){
//        redisTemplate.opsForValue().set("A","666");
//        System.out.println(redisTemplate.opsForValue().get("B"));
    }
}
