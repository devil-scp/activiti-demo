package com.hand.activiti.demo.controller;

import com.hand.activiti.demo.service.ProcessInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by scp on 2020/02/27.
 */
@Controller
@RequestMapping("/v1")
public class TestController {

    @Autowired
    ProcessInstanceService processInstanceService;

    @GetMapping(value = "/run")
    public ResponseEntity create() {
        processInstanceService.runDevopsPipeline();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
