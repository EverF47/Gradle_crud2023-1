package com.abc.CRUDS;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
    {
    @GetMapping("/HELLO")
    @ResponseBody

    public String HELLOWORD()

        {
            return "hello word";
        }

    }
