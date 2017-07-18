package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenEnrollSem2 extends Stage<WhenEnrollSem2> {
	
    private static final Logger LOG = LoggerFactory.getLogger(WhenEnrollSem2.class);

    @Autowired
    private CommonService commonService;

    @Autowired
    private TermService termService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdAssessment assessment;

    @ProvidedScenarioState
    private AdAcademicSession session;

    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private AdEnrollment enrollment;

    @ProvidedScenarioState
    private AdAdmission admission;

    @ProvidedScenarioState
    private AdStudyCenter studyCenter;

    @ProvidedScenarioState
    private AdCohort cohort;

    @ExpectedScenarioState
    private AdGradeCode grade;

    @ExpectedScenarioState
    private AdGradebook gradeBook;

    @ProvidedScenarioState
    private AdSection section;

    @ProvidedScenarioState
    private AdOffering offering;

    @ProvidedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdCourse course;
    
    public WhenEnrollSem2 enrollSem2() throws Exception{
    	
        student = profileService.findStudentByMatricNo("A17M0009F");
        LOG.debug("Student Name:{}",student.getName());
        cohort = student.getCohort();
        LOG.debug("Student Cohort:{}",student.getCohort().getDescription());
        program = cohort.getProgram();
        LOG.debug("Student Program :{}", student.getCohort().getProgram().getCode());
        session = plannerService.findAcademicSessionByCode("201720182");
        LOG.debug("Session:{}",session.getCode());
        course = plannerService.findCourseByCode("GST5063");
        LOG.debug("Course:{}",course.getCode());
        studyCenter = commonService.findStudyCenterByCode("A");
        LOG.debug("StudyCenter :{}",studyCenter.getDescription());
       

        createOffering();
        createSection();
        createAdmission();
        createEnrollment();
    	
    	
		return self();
    	
    }
    
    private void createEnrollment() {
        enrollment = new AdEnrollmentImpl();
        enrollment.setAdmission(admission);
        enrollment.setSection(section);
        enrollment.setGradeCode(commonService.findGradeCodeByCode("A+"));
        enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
        LOG.debug("Enrollment Status :{}", enrollment.getAdmission().getStanding().getDescription());
        LOG.debug("Section :{}",section.getCode());
        LOG.debug("Grade Code :{}", enrollment.getGradeCode().getCode());
        termService.saveEnrollment(enrollment);
    }

    private void createAdmission() {
        admission = new AdAdmissionImpl();
        admission.setGpa(BigDecimal.ZERO);
        admission.setCgpa(BigDecimal.ZERO);
        admission.setCreditTaken(20);
        admission.setCreditEarned(20);
        admission.setStudent(student);
        admission.setStatus(AdAdmissionStatus.ADMITTED);
        admission.setStanding(AdAcademicStanding.TBD);
        admission.setStudyCenter(studyCenter);
        admission.setSession(session);
        admission.setCohort(cohort);
        termService.saveAdmission(admission);
//        LOG.debug("Admission Student Name :{}", admission.getStudent().getName());
//        LOG.debug("Admission study center :{}", admission.getStudyCenter().getDescription());
//        LOG.debug("Admission academic session :{}", admission.getSession().getCode());
//        LOG.debug("Admission cohort :{}", admission.getCohort().getCode());
        LOG.debug("Admission Status :{}",admission.getStatus().name());
        LOG.debug("Admission Standing :{}",admission.getStanding().name());
        LOG.debug("GPA :{}", admission.getGpa());
        LOG.debug("CGPA :{}", admission.getCgpa());
    }

    private void createSection() throws Exception {
        section = new AdSectionImpl();
        section.setCode("Section A");
        section.setCanonicalCode("MASTER-MBA-GST5063-201720182-Section A");
        section.setOrdinal(1);
        section.setCapacity(20);
        section.setOffering(offering);
        termService.addSection(offering, section);
        
        LOG.debug("Section :{}",section.getCode());
        LOG.debug("Section Offering :{}",section.getOffering().getCourse().getCode());
        
    }

    private void createOffering() throws Exception {
        offering = new AdOfferingImpl();
        offering.setCanonicalCode("MASTER-MBA-GST5063-201720182");
        offering.setCode("MASTER-MBA-GST5063");
        offering.setTitleMs("s");
        offering.setTitleEn("s");
        offering.setCapacity(100);
        offering.setProgram(program);
        offering.setCourse(course);
        offering.setSession(session);
        termService.saveOffering(offering);
        LOG.debug("Offering Course:{}", offering.getCourse().getCode());

    }

}
