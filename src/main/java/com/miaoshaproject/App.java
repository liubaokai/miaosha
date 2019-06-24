package com.miaoshaproject;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.response.CommonReturnType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"})
@RestController
@MapperScan("com.miaoshaproject.dao")
public class App {

   @Autowired
   private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public Object home() {
//ctrl+alt+left  跳转到实现的方法
//        找错误的时候如果觉得这个语句有问题，就用try-catch试试，毕竟已经进行了异常处理，把其他的错误信息屏蔽掉了
//        try {
//            UserDO userDO = userDOMapper.selectByPrimaryKey(1);
//        } catch (Exception e) {
//            System.out.println(e);
//
//        }finally {
//            System.out.println("哈哈哈");
//        }

        UserDO userDO = userDOMapper.selectByPrimaryKey(17);
//        System.out.println(userDOMapper.selectByPrimaryKey(1));
        if (userDO == null) {
            return null;
        } else {
            return userDO;
        }

    }




    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
