package my.edu.umk.pams.academic.workflow.integration.event;

import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.workflow.integration.registry.DocumentHandlerRegistry;
import org.activiti.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Component("processListener")
public class ProcessListener implements ApplicationListener<ProcessEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessListener.class);

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

    @Autowired
    private DocumentHandlerRegistry registry;

    @Override
    public void onApplicationEvent(ProcessEvent event) {
        LOG.info("receiving process event");
        AdDocument document = event.getDocument();
        Map variables = event.getVariables();
        registry.process(document, variables);
    }
}
