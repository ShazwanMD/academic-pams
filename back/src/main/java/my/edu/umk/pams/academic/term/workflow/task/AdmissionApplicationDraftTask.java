package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.academic.AcademicConstants.ADMISSION_APPLICATION_ID;
import static my.edu.umk.pams.academic.core.AdFlowState.DRAFTED;
import static org.slf4j.LoggerFactory.getLogger;

@Component("admissionApplication_draft_ST")
public class AdmissionApplicationDraftTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static Logger LOG = getLogger(AdmissionApplicationDraftTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ADMISSION_APPLICATION_ID);
        AdAdmissionApplication application = termService.findAdmissionApplicationById(applicationId);

        LOG.debug("drafting application {}", application.getReferenceNo());

        application.getFlowdata().setState(DRAFTED);
        application.getFlowdata().setDraftedDate(new Timestamp(currentTimeMillis()));
        application.getFlowdata().setDrafterId(securityService.getCurrentUser().getId());
        termService.updateAdmissionApplication(application);
    }
}
