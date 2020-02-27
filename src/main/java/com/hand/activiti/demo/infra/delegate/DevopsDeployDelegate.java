package com.hand.activiti.demo.infra.delegate;

import com.hand.activiti.demo.infra.config.ActivitiInitBeanConfig;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by scp on 2020/02/27.
 */

@Component
public class DevopsDeployDelegate implements JavaDelegate {
    private Logger logger = LoggerFactory.getLogger(DevopsDeployDelegate.class);

    @Autowired
    ProcessRuntime processRuntime;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("====Start task===={}", delegateExecution.getCurrentActivityId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("====Complete task===={}", delegateExecution.getCurrentActivityId());
    }
}
