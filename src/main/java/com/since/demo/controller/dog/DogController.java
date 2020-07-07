package com.since.demo.controller.dog;

import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "狗API接口")
@RestController
@RequestMapping("/test")
public class DogController{
    @Data
    class Dog{
        String name;
        String legs;
    }

    @ApiOperation(value="测试获取一条狗", produces="application/json")
    @GetMapping("/a")
    @ResponseBody
    public Dog test(String word){
        Dog dog = new Dog();
        dog.legs = "4";
        dog.name = "123";
        return dog;
    }
}
