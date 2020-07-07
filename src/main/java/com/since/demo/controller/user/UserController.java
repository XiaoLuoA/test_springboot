package com.since.demo.controller.user;

import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户API接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Data
    static class User{
        String name;
        String legs;
    }


    @ApiOperation(value="返回一个用户", produces="application/json")
    @ApiImplicitParam(name = "id", value = "id",  required = true, dataType = "String")
    @GetMapping("/find")
    public User get(String id){
        User dog = new User();
        dog.legs =id;
        dog.name = "123";
        return dog;
    }

    @ApiOperation(value="增加一个用户", produces="application/json")
    @PostMapping("/add")
    public User test(@RequestBody User user){
        User dog = new User();
        dog.legs = "4";
        dog.name = "123";
        return dog;
    }

    @ApiOperation(value="返回年龄大于1的用户", produces="application/json")
    @GetMapping("/finds")
    public List<User> test(){
        User dog = new User();
        dog.legs = "4";
        dog.name = "123";
        ArrayList<User> arr = new ArrayList();
        arr.add(dog);
        arr.add(dog);
        return arr;
    }
}
