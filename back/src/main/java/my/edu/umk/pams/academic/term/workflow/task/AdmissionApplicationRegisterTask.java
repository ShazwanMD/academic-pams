package my.edu.umk.pams.academic.term.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.service.TermService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static my.edu.umk.pams.academic.AcademicConstants.ADMISSION_APPLICATION_ID;

@Component("admissionApplication_register_ST")
public class AdmissionApplicationRegisterTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final Logger LOG = LoggerFactory.getLogger(AdmissionApplicationRegisterTask.class);

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(ADMISSION_APPLICATION_ID);
        AdAdmissionApplication application = termService.findAdmissionApplicationById(applicationId);

        LOG.debug("registering application {}", application.getReferenceNo());

        application.getFlowdata().setState(AdFlowState.REGISTERED);
        application.getFlowdata().setRegisteredDate(new Timestamp(System.currentTimeMillis()));
        application.getFlowdata().setRegistererId(securityService.getCurrentUser().getId());
        termService.updateAdmissionApplication(application);
    }
}
