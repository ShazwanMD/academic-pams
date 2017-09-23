package my.edu.umk.pams.academic.graduation.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static my.edu.umk.pams.academic.AcademicConstants.GRADUATION_APPLICATION_ID;


@Component("graduationApplication_register_ST")
public class GraduationApplicationRegisterTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(GraduationApplicationRegisterTask.class);

    @Autowired
    private GraduationService graduationService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(GRADUATION_APPLICATION_ID);
        AdGraduationApplication application = graduationService.findGraduationApplicationById(applicationId);

        LOG.debug("registering application {}", application.getReferenceNo());

        application.getFlowdata().setState(AdFlowState.REGISTERED);
        application.getFlowdata().setRegisteredDate(new Timestamp(System.currentTimeMillis()));
        application.getFlowdata().setRegistererId(securityService.getCurrentUser().getId());
        graduationService.updateGraduationApplication(application);
    }
}
