package com.niranjan.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by niranjan on 13/6/18.
 */
@Controller
@RequestMapping(value="/ekyc")
public class TestController {

    //inject via application.properties
    @Value("${welcome.message:test}")
    private String message;

    @RequestMapping(value = "/page")
    public String getJspPage(HttpServletRequest request,Map<String, Object> model){
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping(value = "/json")
    public ResponseEntity getJsonValue(HttpServletRequest request){

        return new ResponseEntity("{'aa':'cccc'}",HttpStatus.OK);
    }
}
