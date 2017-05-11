package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static my.edu.umk.pams.academic.AcademicConstants.ADMISSION_APPLICATION_ID;

@Component("admissionApplication_complete_ST")
public class AdmissionApplicationCompleteTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AdmissionApplicationCompleteTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ADMISSION_APPLICATION_ID);
        AdAdmissionApplication application = termService.findAdmissionApplicationById(applicationId);

        LOG.debug("completing application {}", application.getReferenceNo());

        application.getFlowdata().setState(AdFlowState.COMPLETED);
        termService.updateAdmissionApplication(application);

    }
}
