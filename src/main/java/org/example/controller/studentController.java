package org.example.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(tags = "student")
@RestController
public class studentController {
    @Autowired
    public studentService Studentservice;
    @Autowired
    public RedisTemplate redisTemplate;
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
    @PostMapping(value = "redisTestController.do")
    @ResponseBody
    public String redisTestController(){
        Studentservice.redisTest();
        return "success";
    }
    @PostMapping(value = "change.do")
    @ResponseBody
    public void change(){
        redisTemplate.opsForValue().set("A",1);
    }
    @PostMapping(value = "returnValue.do")
    @ResponseBody
    public void returnValue(){
        redisTemplate.opsForValue().set("A",2);
    }
    @PostMapping(value = "deleteValue.do")
    @ResponseBody
    public void deleteValue(){
        redisTemplate.delete("A");
    }
    @PostMapping(value = "changeValue.do")
    @ResponseBody
    public Map<String,String> changeValue(HttpServletRequest request){
        //用于返回的map
        Map<String,String> result=new HashMap<>();
        String key=request.getParameter("key");
        String value=request.getParameter("value");
        //redis中不存在该键值对时直接重新set一个键值对进去
        if(redisTemplate.opsForValue().get(key)==null) redisTemplate.opsForValue().set(key,value);
        //存在时使用getSet方法
        else redisTemplate.opsForValue().getAndSet(key,value);
        String a=(String) redisTemplate.opsForValue().get("A");
        System.out.println(a);
        result.put("result","100");
        return result;
    }
    @PostMapping(value = "getValue.do")
    @ResponseBody
    public Map<String,String> getValue(HttpServletRequest request){
        //用于返回的map
        Map<String,String> result=new HashMap<>();
        String key=request.getParameter("key");
        String value=request.getParameter("value");
        Object data=null;
        String str=null;
        //redis中不存在该键值对时直接重新set一个键值对进去
        if(key!=null) {
            data=redisTemplate.opsForValue().get(key);
            if(data instanceof Integer) str=String.valueOf(data);
            else str=(String) data;
            result.put("result","100");
            result.put("data",str);
        }
            //存在时使用getSet方法
        else result.put("result","200");
        return result;
    }
}
