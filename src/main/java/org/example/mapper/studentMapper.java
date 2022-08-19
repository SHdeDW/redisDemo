package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.student;

import java.util.List;
@Mapper
public interface studentMapper extends BaseMapper<student> {
    List<student> findAll();
    void insertStudent(student aStudent);
}
