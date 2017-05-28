package my.edu.umk.pams.academic.graduation.workflow.task;

import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;
import static my.edu.umk.pams.academic.AcademicConstants.GRADUATION_APPLICATION_ID;
import static my.edu.umk.pams.academic.core.AdFlowState.DRAFTED;
import static org.slf4j.LoggerFactory.getLogger;

@Component("graduationApplication_draft_ST")
public class GraduationApplicationDraftTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static Logger LOG = getLogger(GraduationApplicationDraftTask.class);

    @Autowired
    private GraduationService financialAidService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(GRADUATION_APPLICATION_ID);
        AdGraduationApplication application = financialAidService.findGraduationApplicationById(applicationId);

        LOG.debug("drafting application {}", application.getReferenceNo());

        application.getFlowdata().setState(DRAFTED);
        application.getFlowdata().setDraftedDate(new Timestamp(currentTimeMillis()));
        application.getFlowdata().setDrafterId(securityService.getCurrentUser().getId());
        financialAidService.updateGraduationApplication(application);
    }
}
