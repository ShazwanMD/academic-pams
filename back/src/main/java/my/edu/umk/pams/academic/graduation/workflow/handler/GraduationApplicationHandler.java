package my.edu.umk.pams.academic.graduation.workflow.handler;

import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
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
public class GraduationApplicationHandler implements DocumentHandler<AdGraduationApplication> {
    private static final Logger LOG = LoggerFactory.getLogger(GraduationApplicationHandler.class);

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
    public String process(AdGraduationApplication graduationApplication, Map<String, Object> variables) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                GRADUATION_APPLICATION_PROCESS_KEY,
                graduationApplication.getReferenceNo(),
                variables);
        LOG.info("Process started for {} with process instance #{} ", GRADUATION_APPLICATION_PROCESS_KEY, instance.getId());
        return instance.getProcessInstanceId();
    }

    @PostConstruct
    public void deployGraduationApplication() {
        DeploymentBuilder deployment = repositoryService.createDeployment();
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        // start only when we don't have one
        long count = query.processDefinitionKey(GRADUATION_APPLICATION_PROCESS_KEY).count();
        if (count < 1) {
            deployment
                    .addClasspathResource(GRADUATION_APPLICATION_RESOURCE_PATH)
                    .name(GRADUATION_APPLICATION_PROCESS_NAME)
                    .deploy();
        }
    }
}
