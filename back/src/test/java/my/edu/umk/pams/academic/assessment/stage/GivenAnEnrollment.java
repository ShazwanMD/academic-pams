package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@JGivenStage
public class GivenAnEnrollment extends Stage<GivenAnEnrollment> {

    private static final Logger LOG = LoggerFactory.getLogger(GivenAnEnrollment.class);

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


    public GivenAnEnrollment create_enrollment() throws Exception {
    	
    	AdAcademicSession academicSessionCode = plannerService.findAcademicSessionByCode("201720181");

        student = profileService.findStudentByMatricNo("A17M0009F");
        LOG.debug("Student Name:{}",student.getName());
        cohort = student.getCohort();
        LOG.debug("Student Cohort:{}",student.getCohort().getDescription());
        program = cohort.getProgram();
        LOG.debug("Student Program :{}", student.getCohort().getProgram().getCode());
        session = plannerService.findCurrentAcademicSession();
        LOG.debug("Session:{}",session.getCode());
        course = plannerService.findCourseByCode("GST5013");
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
    	AdAcademicSession academicSessionCode = plannerService.findAcademicSessionByCode("201720181");
        admission = new AdAdmissionImpl();
        admission.setGpa(BigDecimal.ZERO);
        admission.setCgpa(BigDecimal.ZERO);
        admission.setCreditTaken(20);
        admission.setCreditEarned(20);
        admission.setStudent(student);
        admission.setStatus(AdAdmissionStatus.ADMITTED);
        admission.setStanding(AdAcademicStanding.TBD);
        admission.setStudyCenter(studyCenter);
        admission.setSession(academicSessionCode);
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
        section.setCanonicalCode("MASTER-MBA-GST5013-201720181-Section A");
        section.setOrdinal(1);
        section.setCapacity(20);
        section.setOffering(offering);
        termService.addSection(offering, section);
        
        LOG.debug("Section :{}",section.getCode());
        LOG.debug("Section Offering :{}",section.getOffering().getCourse().getCode());
        
    }

    private void createOffering() throws Exception {
    	AdAcademicSession academicSessionCode = plannerService.findAcademicSessionByCode("201720181");
        offering = new AdOfferingImpl();
        offering.setCanonicalCode("MASTER-MBA-GST5013-201720181");
        offering.setCode("MASTER-MBA-GST5013");
        offering.setTitleMs("s");
        offering.setTitleEn("s");
        offering.setCapacity(100);
        offering.setProgram(program);
        offering.setCourse(course);
        offering.setSession(academicSessionCode);
        termService.saveOffering(offering);
        LOG.debug("Offering Course:{}", offering.getCourse().getCode());

    }
}
