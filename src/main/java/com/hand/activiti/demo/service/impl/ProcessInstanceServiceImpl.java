package com.hand.activiti.demo.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.hand.activiti.demo.service.ProcessInstanceService;
import com.hand.activiti.demo.infra.uitl.ActivitiUserLoginUtil;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;


/**
 * Created by scp on 2020/02/27.
 */
@Service
public class ProcessInstanceServiceImpl implements ProcessInstanceService {


    @Autowired
    RepositoryService repositoryService;
    @Autowired
    ProcessRuntime processRuntime;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskRuntime taskRuntime;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ActivitiUserLoginUtil activitiUserLoginUtil;

    private Logger logger = LoggerFactory.getLogger(ProcessInstanceServiceImpl.class);


    @Override
    public void runDevopsPipeline() {
        login();
        String name = "Hello World Activiti";

        String key = UUID.randomUUID().toString();
        processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey("Process")
                .withName(name)
                .withBusinessKey(key)
                .build());
    }

    private void login() {
        String[] user = {"131547", "password", "ROLE_ACTIVITI_USER", "test"};
        List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
        if (!((InMemoryUserDetailsManager) userDetailsService).userExists("131547")) {
            ((InMemoryUserDetailsManager) userDetailsService).createUser(new User(user[0], passwordEncoder.encode(user[1]),
                    authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }
        activitiUserLoginUtil.logInAs("131547");

    }

}
