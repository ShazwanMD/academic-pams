package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_ID;

@Component("enrollmentApplication_complete_ST")
public class EnrollmentApplicationCompleteTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(EnrollmentApplicationCompleteTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ENROLLMENT_APPLICATION_ID);
        AdEnrollmentApplication application = termService.findEnrollmentApplicationById(applicationId);

        LOG.debug("completing application {}", application.getReferenceNo());

        application.getFlowdata().setState(AdFlowState.COMPLETED);
        termService.updateEnrollmentApplication(application);
    }
}
