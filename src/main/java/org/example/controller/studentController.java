package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class studentController {
    @Autowired
    public studentService Studentservice;
    @PostMapping(value = "selectController.do")
    @ResponseBody
    public String selectController(){
        System.out.println("controller注入");
        Studentservice.getStudent();
        return "success";
    }
    @PostMapping(value = "insertController.do")
    @ResponseBody
    public String insertController(){
        Studentservice.insertStudent();
        return "success";
    }
}
