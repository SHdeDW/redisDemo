package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.student;

import java.util.List;
@Mapper
public interface studentMapper {
    List<student> findAll();
    void insertStudent(student aStudent);
}
