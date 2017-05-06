package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.core.vo.FlowState;
import my.edu.umk.pams.academic.web.module.core.vo.MetaState;
import my.edu.umk.pams.academic.web.module.identity.controller.IdentityTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component("termTransformer")
public class TermTransformer {

    @Autowired
    private TermService termService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityTransformer identityTransformer;

    public AdmissionApplicationTask toAdmissionApplicationTaskVo(Task t) {
        Map<String, Object> vars = workflowService.getVariables(t.getExecutionId());
        AdAdmissionApplication application = termService.findAdmissionApplicationById((Long) vars.get(AcademicConstants.ADMISSION_APPLICATION_ID));

        AdmissionApplicationTask task = new AdmissionApplicationTask();
        task.setId(application.getId());
        task.setTaskId(t.getId());
        task.setReferenceNo(application.getReferenceNo());
        task.setSourceNo(application.getSourceNo());
        task.setDescription(application.getDescription());
        task.setTaskName(t.getName());
        task.setAssignee(task.getAssignee());
        task.setCandidate(task.getCandidate());
        task.setApplication(toAdmissionApplicationVo(application));
        task.setFlowState(FlowState.get(application.getFlowdata().getState().ordinal()));
        task.setMetaState(MetaState.get(application.getMetadata().getState().ordinal()));
        return task;
    }

    public AdmissionApplication toAdmissionApplicationVo(AdAdmissionApplication e) {
        AdmissionApplication vo = new AdmissionApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setSourceNo(e.getSourceNo());
        vo.setAuditNo(e.getAuditNo());
        vo.setDescription(e.getDescription());
        vo.setFlowState(FlowState.get(e.getFlowdata().getState().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Admission toAdmissionVo(AdAdmission admission) {
        Admission m = new Admission();
        m.setId(admission.getId());
        m.setGpa(admission.getGpa());
        m.setCgpa(admission.getCgpa());
        m.setCreditEarned(admission.getCreditEarned());
        m.setCreditTaken(admission.getCreditTaken());
        return m;
    }

    public Appointment toAppointmentVo(AdAppointment appointment) {
        Appointment m = new Appointment();
        m.setId(appointment.getId());
        return m;
    }

    public EnrollmentApplicationTask toEnrollmentApplicationTaskVo(Task t) {
        Map<String, Object> vars = workflowService.getVariables(t.getExecutionId());
        AdEnrollmentApplication application = termService.findEnrollmentApplicationById((Long) vars.get(AcademicConstants.ENROLLMENT_APPLICATION_ID));

        EnrollmentApplicationTask task = new EnrollmentApplicationTask();
        task.setId(application.getId());
        task.setTaskId(t.getId());
        task.setReferenceNo(application.getReferenceNo());
        task.setSourceNo(application.getSourceNo());
        task.setDescription(application.getDescription());
        task.setTaskName(t.getName());
        task.setAssignee(task.getAssignee());
        task.setCandidate(task.getCandidate());
        task.setApplication(toEnrollmentApplicationVo(application));
        task.setFlowState(FlowState.get(application.getFlowdata().getState().ordinal()));
        task.setMetaState(MetaState.get(application.getMetadata().getState().ordinal()));
        return task;
    }

    public EnrollmentApplication toEnrollmentApplicationVo(AdEnrollmentApplication e) {
        EnrollmentApplication vo = new EnrollmentApplication();
        vo.setId(e.getId());
        vo.setReferenceNo(e.getReferenceNo());
        vo.setSourceNo(e.getSourceNo());
        vo.setAuditNo(e.getAuditNo());
        vo.setDescription(e.getDescription());
        vo.setFlowState(FlowState.get(e.getFlowdata().getState().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Enrollment toEnrollmentVo(AdEnrollment enrollment) {
        Enrollment m = new Enrollment();
        m.setId(enrollment.getId());
        return m;
    }

    public Offering toOfferingVo(AdOffering offering) {
        Offering m = new Offering();
        m.setId(offering.getId());
        return m;
    }

    public Section toSectionVo(AdSection section) {
        Section m = new Section();
        m.setId(section.getId());
        return m;
    }

    public List<AdmissionApplicationTask> toAdmissionApplicationTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toAdmissionApplicationTaskVo(task))
                .collect(toCollection(() -> new ArrayList<AdmissionApplicationTask>()));
    }

    public List<AdmissionApplication> toAdmissionApplicationVos(List<AdAdmissionApplication> journals) {
        return journals.stream()
                .map((task) -> toAdmissionApplicationVo(task))
                .collect(toCollection(() -> new ArrayList<AdmissionApplication>()));
    }

    public List<Admission> toAdmissionVos(List<AdAdmission> admissions) {
        List<Admission> vos = admissions.stream()
                .map((admission) -> toAdmissionVo(admission))
                .collect(toList());
        return vos;
    }

    public List<Enrollment> toEnrollmentVos(List<AdEnrollment> enrollments) {
        List<Enrollment> vos = enrollments.stream()
                .map((enrollment) -> toEnrollmentVo(enrollment))
                .collect(toList());
        return vos;
    }

    public List<Appointment> toAppointmentVos(List<AdAppointment> appointments) {
        List<Appointment> vos = appointments.stream()
                .map((appointment) -> toAppointmentVo(appointment))
                .collect(toList());
        return vos;
    }

    public List<Offering> toOfferingVos(List<AdOffering> offerings) {
        List<Offering> vos = offerings.stream()
                .map((offering) -> toOfferingVo(offering))
                .collect(toList());
        return vos;
    }

    public List<Section> toSectionVos(List<AdSection> sections) {
        List<Section> vos = sections.stream()
                .map((section) -> toSectionVo(section))
                .collect(toList());
        return vos;
    }

    public List<EnrollmentApplicationTask> toEnrollmentApplicationTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toEnrollmentApplicationTaskVo(task))
                .collect(toCollection(() -> new ArrayList<EnrollmentApplicationTask>()));
    }

}
