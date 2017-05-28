package my.edu.umk.pams.academic.graduation.workflow.task;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import org.activiti.engine.impl.bpmn.behavior.BpmnActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static my.edu.umk.pams.academic.AcademicConstants.GRADUATION_APPLICATION_ID;
import static my.edu.umk.pams.academic.workflow.service.WorkflowConstants.REMOVE_COMMENT;


@Component("graduationApplication_remove_ST")
public class GraduationApplicationRemoveTask extends BpmnActivityBehavior
        implements ActivityBehavior {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(GraduationApplicationRemoveTask.class);

    @Autowired
    private GraduationService financialAidService;

    @Autowired
    private SecurityService securityService;

    public void execute(ActivityExecution execution) throws Exception {
        Long applicationId = (Long) execution.getVariable(GRADUATION_APPLICATION_ID);
        AdGraduationApplication application = financialAidService.findGraduationApplicationById(applicationId);

        LOG.debug("removing application {}", application.getReferenceNo());
        String removeComment = (String) execution.getVariable(REMOVE_COMMENT);
        application.setRemoveComment(removeComment);

        application.getFlowdata().setState(AdFlowState.REMOVED);
        application.getFlowdata().setRemovedDate(new Timestamp(System.currentTimeMillis()));
        application.getFlowdata().setRemoverId(securityService.getCurrentUser().getId());
        financialAidService.updateGraduationApplication(application);
    }
}
