package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.academic.web.module.core.vo.FlowState;
import my.edu.umk.pams.academic.web.module.core.vo.MetaState;
import my.edu.umk.pams.academic.web.module.identity.controller.IdentityTransformer;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	 private static final Logger LOG = LoggerFactory.getLogger(TermTransformer.class);

    @Autowired
    private TermService termService;
    
    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityTransformer identityTransformer;
    
    @Autowired
    private CommonTransformer commonTransformer;

    @Autowired
    private PlannerTransformer plannerTransformer;
    
    @Autowired
    private TermTransformer termTransformer;

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
        Admission vo = new Admission();
        vo.setId(admission.getId());
        vo.setGpa(admission.getGpa());
        vo.setCgpa(admission.getCgpa());
        vo.setCreditEarned(admission.getCreditEarned());
        vo.setCreditTaken(admission.getCreditTaken());
        vo.setStudent(identityTransformer.toStudentVo(admission.getStudent()));
        vo.setAcademicSession(plannerTransformer.toAcademicSessionVo(admission.getSession()));
        vo.setCohort(plannerTransformer.toCohortVo(admission.getCohort()));
        vo.setAdmissionStatus(AdmissionStatus.get(admission.getStatus().ordinal()));
        vo.setAcademicStanding(AcademicStanding.get(admission.getStanding().ordinal()));
        //vo.setEnrollmentStanding(EnrollmentStanding.get(enrollment.getStanding().ordinal()));
        return vo;
    }

    public Appointment toAppointmentVo(AdAppointment appointment) {
        Appointment vo = new Appointment();
        vo.setId(appointment.getId());
        //vo.setAppointmentStatus(appointment.getStatus());
        vo.setStaff(identityTransformer.toStaffVo(appointment.getStaff()));
        vo.setSection(this.toSectionVo(appointment.getSection()));
        return vo;
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
        vo.setEnrollmentApplicationType(EnrollmentApplicationType.get(vo.getEnrollmentApplicationType().ordinal()));
        vo.setRemoveComment(e.getRemoveComment());
        vo.setCancelComment(e.getCancelComment());
        vo.setFlowState(FlowState.get(e.getFlowdata().getState().ordinal()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public EnrollmentApplicationItem toEnrollmentApplicationItemVo(AdEnrollmentApplicationItem e) {
        EnrollmentApplicationItem vo = new EnrollmentApplicationItem();
        vo.setId(e.getId());
        vo.setSection(toSectionVo(e.getSection()));
        vo.setMetaState(MetaState.get(e.getMetadata().getState().ordinal()));
        return vo;
    }

    public Enrollment toEnrollmentVo(AdEnrollment enrollment) {
        Enrollment vo = new Enrollment();
        vo.setId(enrollment.getId());
        vo.setAdmission(this.toAdmissionVo(enrollment.getAdmission()));
       // vo.setGradeCode(commonTransformer.toGradeCodeVo(enrollment.getGradeCode()));
        vo.setSection(this.toSectionVo(enrollment.getSection()));
        vo.setEnrollmentStanding(EnrollmentStanding.get(enrollment.getStanding().ordinal()));
        vo.setEnrollmentStatus(EnrollmentStatus.get(enrollment.getStatus().ordinal()));
               
        return vo;
    }

    public Offering toOfferingVo(AdOffering offering) {
        Offering vo = new Offering();
        vo.setId(offering.getId());
        vo.setCode(offering.getCode());
        vo.setCanonicalCode(offering.getCanonicalCode());
        vo.setCapacity(offering.getCapacity());
        vo.setTitleMs(offering.getTitleMs());
        vo.setTitleEn(offering.getTitleEn());
        vo.setCourse(plannerTransformer.toCourseVo(offering.getCourse()));
        vo.setProgram(plannerTransformer.toProgramVo(offering.getProgram()));
        vo.setAcademicSession(plannerTransformer.toAcademicSessionVo(offering.getSession()));
        return vo;
    }

    public Section toSectionVo(AdSection section) {
        Section vo = new Section();
        vo.setId(section.getId());
        vo.setCode(section.getCode());
        vo.setCanonicalCode(section.getCanonicalCode());
        vo.setCapacity(section.getCapacity());
        vo.setOrdinal(section.getOrdinal());
        vo.setOffering(this.toOfferingVo(section.getOffering()));
        return vo;
    }

    public Assessment toAssessmentVo(AdAssessment assessment) {
        Assessment vo = new Assessment();
        vo.setId(assessment.getId());
        vo.setCode(assessment.getCode());
        vo.setCanonicalCode(assessment.getCanonicalCode());
        vo.setDescription(assessment.getDescription());
        vo.setOrdinal(assessment.getOrdinal());
        vo.setWeight(assessment.getWeight());
        vo.setTotalScore(assessment.getTotalScore());
        vo.setAssessmentType(AssessmentType.get(assessment.getType().ordinal()));
        vo.setAssessmentCategory(AssessmentCategory.get(assessment.getCategory().ordinal()));
//        vo.setOffering(this.toOfferingVo(assessment.getOffering()));
        return vo;
    }

    public List<AdmissionApplicationTask> toAdmissionApplicationTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toAdmissionApplicationTaskVo(task))
                .collect(toCollection(() -> new ArrayList<AdmissionApplicationTask>()));
    }

    public List<EnrollmentApplicationTask> toEnrollmentApplicationTaskVos(List<Task> tasks) {
        return tasks.stream()
                .map((task) -> toEnrollmentApplicationTaskVo(task))
                .collect(toCollection(() -> new ArrayList<EnrollmentApplicationTask>()));
    }


    public List<AdmissionApplication> toAdmissionApplicationVos(List<AdAdmissionApplication> items) {
        return items.stream()
                .map((task) -> toAdmissionApplicationVo(task))
                .collect(toCollection(() -> new ArrayList<AdmissionApplication>()));
    }

    public List<EnrollmentApplication> toEnrollmentApplicationVos(List<AdEnrollmentApplication> items) {
        return items.stream()
                .map((task) -> toEnrollmentApplicationVo(task))
                .collect(toCollection(() -> new ArrayList<EnrollmentApplication>()));
    }

    public List<EnrollmentApplicationItem> toEnrollmentApplicationItemVos(List<AdEnrollmentApplicationItem> items) {
        return items.stream()
                .map((task) -> toEnrollmentApplicationItemVo(task))
                .collect(toCollection(() -> new ArrayList<EnrollmentApplicationItem>()));
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

    public List<Assessment> toAssessmentVos(List<AdAssessment> assessments) {
        List<Assessment> vos = assessments.stream()
                .map((assessment) -> toAssessmentVo(assessment))
                .collect(toList());
        return vos;
    }
}
