package org.example.service.Impl;

import org.example.entity.student;
import org.example.mapper.*;
import org.example.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper studentsMapper;
    public void getStudent(){
        System.out.println("service成功注入");
        List<student> result=studentsMapper.findAll();
    }
    public void insertStudent(){
        student aStudent=new student();
        aStudent.setId(0);
        studentsMapper.insertStudent(aStudent);

    }
}
