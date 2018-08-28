package com.example.demo.Controller;

import com.example.demo.Model.HelloModel;
import com.example.demo.Model.ReqBody;
import com.example.demo.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class HelloWorld {
    private final HelloService HelloService;

    @Autowired
    public HelloWorld(HelloService HelloService) {
        this.HelloService = HelloService;

    }

    @RequestMapping("/")
    public String Index() {
        return "Hello World";
    }

    @RequestMapping("/list")
    public List<HelloModel> List() {
        return HelloService.selectAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String Post(
            @RequestBody ReqBody map
    ) throws  IOException {
        return "输入的姓名是" + map.getName() + ",电子邮件是:" + map.getEmail();
    }
}
