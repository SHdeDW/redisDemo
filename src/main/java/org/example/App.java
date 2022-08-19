package org.example;

import org.example.controller.studentController;
import org.example.util.YamlUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.yaml.snakeyaml.Yaml;
import redis.clients.jedis.Jedis;
import org.springframework.boot.SpringApplication;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@MapperScan(basePackages = "org.example.mapper")
public class App
{

    public static void main( String[] args ) throws IOException {

        SpringApplication.run(App.class,args);
        System.out.println( "Hello World!" );
        String value= YamlUtil.getValueByKey("application.yml","spring","version");
        System.out.println(value);
/*        int start=value.indexOf("mysql://");
        int end=value.indexOf("/mydb");
        String str=value.substring(start,end);
        System.out.println(value);
        System.out.println(str);
        /*Jedis jedis=new Jedis("localhost");
        System.out.println("ling start");
        System.out.println("服务连接结果："+jedis.ping());
        System.out.println(jedis.getSet("A","666"));
        List<String> list=new ArrayList<>();

          long startTime = System.currentTimeMillis();
        String a;
        for(int i=0;i<100000;i++) {
            jedis.getSet("A","2");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("所用时间为:"+(endTime-startTime)/1000);
*/    }

}
