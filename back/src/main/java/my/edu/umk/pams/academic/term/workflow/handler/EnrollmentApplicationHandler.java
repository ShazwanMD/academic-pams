package my.edu.umk.pams.academic.term.workflow.handler;


import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.workflow.integration.registry.DocumentHandler;
import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

import static my.edu.umk.pams.academic.AcademicConstants.*;

/**
 * @author PAMS
 */
@Component
public class EnrollmentApplicationHandler implements DocumentHandler<AdEnrollmentApplication> {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentApplicationHandler.class);

    @Autowired
    protected ProcessEngine processEngine;

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected HistoryService historyService;

    @Autowired
    protected RepositoryService repositoryService;

    @Override
    public String process(AdEnrollmentApplication application, Map<String, Object> variables) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                ENROLLMENT_APPLICATION_PROCESS_KEY,
                application.getReferenceNo(),
                variables);
        LOG.info("Process started for {} with process instance #{} ", ENROLLMENT_APPLICATION_PROCESS_KEY, instance.getId());
        return instance.getProcessInstanceId();
    }

    @PostConstruct
    public void deployInvoice() {
        DeploymentBuilder deployment = repositoryService.createDeployment();
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        // start only when we don't have one
        long count = query.processDefinitionKey(ENROLLMENT_APPLICATION_PROCESS_KEY).count();
        if (count < 1) {
            deployment
                    .addClasspathResource(ENROLLMENT_APPLICATION_RESOURCE_PATH)
                    .name(ENROLLMENT_APPLICATION_PROCESS_NAME)
                    .deploy();
        }
    }
}
