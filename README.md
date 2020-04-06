# activiti demo
 
- This is a demo project based on Spring Boot and activiti 7.0.109;
- BMPN file in src\main\resources\bmpn directory;
- The custom delegate class is DevopsDeployDelegate, which has a print log;
- The entry point for program testing is TestController, and the API is `v1/run`
- When you call at `http://localhost:8080/v1/run`, You will see the following log:
    ````
    ====Start task====subProcess0-serviceTask1
    ====Start task====subProcess0-serviceTask2
    ====Complete task=====subProcess0-serviceTask1
    ====Complete task=====subProcess0-serviceTask2
    ====Start task====subProcess0-serviceTask1
    ====Complete task=====subProcess0-serviceTask1
    Hello World Activiti:The process to complete!!!
    ````
- You can see that serviceTask1 is executed twice.
- When I used activiti 7.1.0.m6, there was a new problem as follows:
    ````
    org.activiti.engine.ActivitiException: Query return 2 results instead of max 1
        at org.activiti.engine.impl.DeploymentQueryImpl.executeSingleResult(DeploymentQueryImpl.java:213) ~[activiti-engine-7.1.0.M6.jar:na]
        at org.activiti.engine.impl.DeploymentQueryImpl.executeSingleResult(DeploymentQueryImpl.java:30) ~[activiti-engine-7.1.0.M6.jar:na]
        at org.activiti.engine.impl.AbstractQuery.execute(AbstractQuery.java:165) [activiti-engine-7.1.0.M6.jar:na]
    ````


    test！！！！


