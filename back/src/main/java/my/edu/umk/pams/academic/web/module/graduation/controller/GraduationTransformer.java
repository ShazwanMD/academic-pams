package my.edu.umk.pams.academic.web.module.graduation.controller;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.web.module.core.vo.FlowState;
import my.edu.umk.pams.academic.web.module.core.vo.MetaState;
import my.edu.umk.pams.academic.web.module.graduation.vo.GraduationApplication;
import my.edu.umk.pams.academic.web.module.graduation.vo.GraduationApplicationTask;
import my.edu.umk.pams.academic.web.module.identity.controller.IdentityTransformer;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.profile.controller.ProfileTransformer;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

/**
 * @author PAMS
 */
@Component("graduationTransformer")
public class GraduationTransformer {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private GraduationService graduationService;

    @Autowired
    private PlannerTransformer plannerTransformer;

    @Autowired
    private ProfileTransformer profileTransformer;

    @Autowired
    private IdentityTransformer identityTransformer;

    public GraduationApplicationTask toGraduationApplicationTaskVo(Task t) {
        Map<String, Object> vars = workflowService.getVariables(t.getExecutionId());
        AdGraduationApplication application = graduationService
                .findGraduationApplicationById((Long) vars.get(AcademicConstants.GRADUATION_APPLICATION_ID));

        GraduationApplicationTask task = new GraduationApplicationTask();
        task.setId(application.getId());
        task.setTaskId(t.getId());
        task.setReferenceNo(application.getReferenceNo());
        task.setSourceNo(application.getSourceNo());
        task.setDescription(application.getDescription());
        task.setTaskName(t.getName());
        task.setAssignee(task.getAssignee());
        task.setCandidate(task.getCandidate());
        task.setApplication(toGraduationApplicationVo(application));
        task.setStudent(identityTransformer.toStudentVo(application.getStudent())); // flatten
        task.setFlowState(FlowState.get(application.getFlowdata().getState().ordinal()));
        task.setMetaState(MetaState.get(application.getMetadata().getState().ordinal()));
        return task;
    }

    public GraduationApplication toGraduationApplicationVo(AdGraduationApplication e) {
        GraduationApplication vo = new GraduationApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setSourceNo(e.getSourceNo());
        vo.setDescription(e.getDescription());
        vo.setStudent(identityTransformer.toStudentVo(e.getStudent()));
        vo.setAcademicSession(plannerTransformer.toAcademicSessionVo(e.getSession()));
        vo.setFlowState(FlowState.get(e.getFlowdata().getState().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public List<GraduationApplicationTask> toGraduationApplicationTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toGraduationApplicationTaskVo(task))
                .collect(toCollection(() -> new ArrayList<GraduationApplicationTask>()));
    }

    public List<GraduationApplication> toGraduationApplicationVos(List<AdGraduationApplication> entries) {
        return entries.stream()
                .map((entry) -> toGraduationApplicationVo(entry))
                .collect(toCollection(() -> new ArrayList<GraduationApplication>()));
    }
}
