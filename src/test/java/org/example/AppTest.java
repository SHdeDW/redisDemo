package org.example;

import static java.lang.Class.forName;
import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.common.base.Supplier;
import org.junit.Test;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.TestClass;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.BiFunction;

public class AppTest
{

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Class aClass= forName("org.example.clas.testClass");
        Object obj=aClass.newInstance();
        System.out.println(obj);
        Field AField=aClass.getDeclaredField("a");
        AField.setAccessible(true);
        System.out.println(AField.getName());
        AField.set(obj,1);
        Modifier modifier=new Modifier();
/*
        System.out.println(modifier.toString(1));
*/
        System.out.println(modifier.toString(AField.getModifiers()));
        System.out.println(AField.get(obj));
        System.out.println(AField.getModifiers());
        System.out.println();
        Method babala=obj.getClass().getDeclaredMethod("testBabala");
        babala.invoke(obj);
        System.out.println(babala.getName());
        System.out.println(babala.getClass());
        babala.invoke(obj);
        return;

/*
        List<Map<String, Object>> map=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("url","localhost:8080");
        map.add(map1);
        String url="localhost:8080";
        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("345");
        System.out.println(list.get(1));
        List<String> aList=new ArrayList<>();
        aList.add("111");
        aList.add("222");
        aList.add("333");
        list.addAll(aList);
        System.out.println(list.get(1));
        Iterator it=list.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        for(Map<String,Object> temp : map){
            System.out.println(temp.get("url"));
            System.out.println(url);
            System.out.println(temp.get("url")==url);
        }
        String str11="111";
        String str22="111";
        System.out.println(str11==str22);
        System.out.println(str11.equals(str22));
        map1.put("null",null);
        if(map1.get("null")==null) System.out.println(1);
        String str1=null;
        System.out.println(str1);
        //这是一段只读注释
        Integer integer=1;
        String[] mystr=new String[2];
        System.out.println(mystr[0]);
        String str="1";
        boolean b=(Integer.valueOf(str)==1);
        System.out.println(b);
        String aaaaa="1";

*/
    }
}
