package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_ID;


@Component("enrollmentApplication_approve_ST")
public class EnrollmentApplicationApproveTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollmentApplicationApproveTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ApplicationContext applicationContext;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ENROLLMENT_APPLICATION_ID);
        AdEnrollmentApplication application = termService.findEnrollmentApplicationById(applicationId);
        LOG.debug("approving application {}", application.getReferenceNo());

        // update flow state
        application.getFlowdata().setState(AdFlowState.APPROVED);
        application.getFlowdata().setApprovedDate(new Timestamp(System.currentTimeMillis()));
        application.getFlowdata().setApproverId(securityService.getCurrentUser().getId());
        termService.updateEnrollmentApplication(application);

        termService.postToEnrollment(application);
    }
}
