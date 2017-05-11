package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_ID;
import static my.edu.umk.pams.academic.core.AdFlowState.DRAFTED;
import static org.slf4j.LoggerFactory.getLogger;

@Component("enrollmentApplication_draft_ST")
public class EnrollmentApplicationDraftTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static Logger LOG = getLogger(EnrollmentApplicationDraftTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ENROLLMENT_APPLICATION_ID);
        AdEnrollmentApplication application = termService.findEnrollmentApplicationById(applicationId);

        LOG.debug("drafting application {}", application.getReferenceNo());

        application.getFlowdata().setState(DRAFTED);
        application.getFlowdata().setDraftedDate(new Timestamp(currentTimeMillis()));
        application.getFlowdata().setDrafterId(securityService.getCurrentUser().getId());
        termService.updateEnrollmentApplication(application);
    }
}
