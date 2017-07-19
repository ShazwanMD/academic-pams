package my.edu.umk.pams.academic.planner.stage;

/**
 * I Am Student
 * I Review Course Info
 * Course Information Reviewed
 *
 * @author zaida
 */

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplicationImpl;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.term.model.AdAssessmentImpl;
import my.edu.umk.pams.academic.term.model.AdAssessmentType;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdGradebookImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@JGivenStage
public class WhenAggregateAllSessions extends Stage<WhenAggregateAllSessions> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAggregateAllSessions.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PlannerService plannerService;
    
    @Autowired
    private CommonService commonService;

    @Autowired
    private TermService termService;

    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private List<AdAdmissionApplication> applications;

    @ProvidedScenarioState
    private List<AdAcademicSession> academicSessions;

    public WhenAggregateAllSessions I_gather_aggregate_applications() throws Exception {

        academicSessions = plannerService.findAcademicSessions(0, 9999); // get all
        final int ACTUAL = academicSessions.size();
        final int EXPECTED = 3; // This is all we have now
        LOG.debug("Found {} AcademicSessions for ALL times", ACTUAL);
        Assert.isTrue(EXPECTED >= ACTUAL, "Expected " + EXPECTED + " but found " + ACTUAL);
        
        
//=========================================================================================
//								SEM 1
//=========================================================================================

		AdAdmissionApplication application = new AdAdmissionApplicationImpl();
        application.setOrdinal(1);
        application.setStudent(identityService.findStudentByMatricNo("A17P006"));
        application.setAdvisor(identityService.findStaffByIdentityNo("01610B"));
        application.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        application.setStudyCenter(commonService.findStudyCenterByCode("A"));
        application.setSession(plannerService.findAcademicSessionByCode("201720181"));
        application.setDescription("Sem1 Student");
        application.setReferenceNo("Sem1");
        termService.saveAdmissionApplication(application);
        LOG.debug("Student:{}",application.getStudent().getIdentityNo());
        LOG.debug("Advisor:{}",application.getAdvisor().getIdentityNo());
        LOG.debug("Program:{}",application.getProgram().getCode());
        LOG.debug("StudyCenter:{}",application.getStudyCenter().getCode());
        LOG.debug("Session:{}",application.getSession().getCode());
        
        AdAdmission admission = new AdAdmissionImpl();
        admission.setStudyCenter(commonService.findStudyCenterByCode("A"));
        admission.setStudent(identityService.findStudentByMatricNo("A17P006"));
        admission.setSession(plannerService.findAcademicSessionByCode("201720181"));
        admission.setStatus(AdAdmissionStatus.REGULAR);
        admission.setStanding(AdAcademicStanding.KB);
        admission.setOrdinal(1);
        admission.setGpa(BigDecimal.ZERO);
        admission.setCgpa(BigDecimal.ZERO);
        admission.setCreditEarned(0);
        admission.setCreditTaken(0);
        admission.setCohort(plannerService.findCohortByCode("MGSEB-MBA-CHRT-001"));
        termService.saveAdmission(admission);
        
        AdOffering offering = new AdOfferingImpl();
        offering.setCanonicalCode("Sem_1_Offering");
        offering.setCapacity(100);
        offering.setCode("Sem1");
        offering.setCourse(plannerService.findCourseByCode("GST5013"));
        offering.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        offering.setTitleEn("Sem1");
        offering.setTitleMs("sem1");
        termService.saveOffering(offering);
        
        AdSection section1 = new AdSectionImpl();
        section1.setCanonicalCode("Section 1");
        section1.setCapacity(10);
        section1.setCode("Section 1");
        section1.setOrdinal(1);
        section1.setOffering(offering);
        termService.saveSection(section1);
        
        AdEnrollment enrollment = new AdEnrollmentImpl();
        enrollment.setAdmission(admission);
        enrollment.setGradeCode(commonService.findGradeCodeByCode("A"));
        enrollment.setSection(section1);
        enrollment.setStanding(AdEnrollmentStanding.HW);
        enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
        enrollment.setTotalScore(BigDecimal.ZERO);
        termService.saveEnrollment(enrollment);
        
        
        AdAssessment assessment1 = new AdAssessmentImpl();
        assessment1.setCode("MASTER-MBA-GST5013-Q1");
		assessment1.setCanonicalCode("MASTER-MBA-GST5013-201720181-Q1");
		assessment1.setDescription("Economics & Business Environment");
		assessment1.setOrdinal(0);
		assessment1.setWeight(new BigDecimal(BigInteger.valueOf(40)));
		assessment1.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment1.setType(AdAssessmentType.QUIZ);
		assessment1.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment1.setOffering(offering);
		termService.addAssessment( offering, assessment1);
		Assert.notNull(assessment1, "assessment1 quiz1 is null");
		//LOG Debug Quiz 1
		LOG.debug("QUIZ 1 :========>");
		LOG.debug("QUIZ 1 Category :{}", assessment1.getCategory().name());
		LOG.debug("QUIZ 1 Code :{}", assessment1.getCode());
		LOG.debug("QUIZ 1 Type :{}", assessment1.getType().name());
		LOG.debug("QUIZ 1 TotalScore :{}", assessment1.getTotalScore().byteValueExact());
		LOG.debug("QUIZ 1 Weight :{}", assessment1.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment1, "assessment1 Quiz1 is not setup");
		
		
		AdGradebook gradebook1 = new AdGradebookImpl();
		gradebook1.setScore(new BigDecimal(BigInteger.valueOf(50)));
		gradebook1.setAssessment(assessment1);
		gradebook1.setEnrollment(enrollment);
		gradebook1.setSection(section1);
		termService.addGradebook(section1, enrollment, gradebook1);
		LOG.debug("gradebook Assessment:{}", gradebook1.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook1.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook1.getScore());
		Assert.notNull(gradebook1, "gradebook1 cannot be null");
		
        AdAssessment assessment2 = new AdAssessmentImpl();
        assessment2.setCode("MASTER-MBA-GST5013-Final");
		assessment2.setCanonicalCode("MASTER-MBA-GST5013-201720181-Final");
		assessment2.setDescription("Economics & Business Environment");
		assessment2.setOrdinal(0);
		assessment2.setWeight(new BigDecimal(BigInteger.valueOf(60)));
		assessment2.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment2.setType(AdAssessmentType.FINAL_EXAM);
		assessment2.setCategory(AdAssessmentCategory.EXAM_WORK);
		assessment2.setOffering(offering);
		termService.addAssessment( offering, assessment2);
		Assert.notNull(assessment2, "assessment2 Final is null");
		//LOG Debug Quiz 1
		LOG.debug("Final :========>");
		LOG.debug("Final Category :{}", assessment2.getCategory().name());
		LOG.debug("Final Code :{}", assessment2.getCode());
		LOG.debug("Final Type :{}", assessment2.getType().name());
		LOG.debug("Final TotalScore :{}", assessment2.getTotalScore().byteValueExact());
		LOG.debug("Final Weight :{}", assessment2.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment2, "assessment2 Final is not setup");
		
		AdGradebook gradebook2 = new AdGradebookImpl();
		gradebook2.setScore(new BigDecimal(BigInteger.valueOf(50)));
		gradebook2.setAssessment(assessment2);
		gradebook2.setEnrollment(enrollment);
		gradebook2.setSection(section1);
		termService.addGradebook(section1, enrollment, gradebook2);
		LOG.debug("gradebook Assessment:{}", gradebook2.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook2.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook2.getScore());
		Assert.notNull(gradebook2, "gradebook2 cannot be null");
		
		termService.calculateGradebook(offering);
		termService.calculateGPA(admission);
        
//=========================================================================================
//							SEM 2
//=========================================================================================

        AdAdmissionApplication application2 = new AdAdmissionApplicationImpl();
        application2.setOrdinal(1);
        application2.setStudent(identityService.findStudentByMatricNo("A17P006"));
        application2.setAdvisor(identityService.findStaffByIdentityNo("01610B"));
        application2.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        application2.setStudyCenter(commonService.findStudyCenterByCode("A"));
        application2.setSession(plannerService.findAcademicSessionByCode("201720182"));
        application2.setDescription("Sem2 Student");
        application2.setReferenceNo("Sem2");
        termService.saveAdmissionApplication(application2);
        LOG.debug("Student:{}",application2.getStudent().getIdentityNo());
        LOG.debug("Advisor:{}",application2.getAdvisor().getIdentityNo());
        LOG.debug("Program:{}",application2.getProgram().getCode());
        LOG.debug("StudyCenter:{}",application2.getStudyCenter().getCode());
        LOG.debug("Session:{}",application2.getSession().getCode());
        
        AdAdmission admission2 = new AdAdmissionImpl();
        admission2.setStudyCenter(commonService.findStudyCenterByCode("A"));
        admission2.setStudent(identityService.findStudentByMatricNo("A17P006"));
        admission2.setSession(plannerService.findAcademicSessionByCode("201720182"));
        admission2.setStatus(AdAdmissionStatus.REGULAR);
        admission2.setStanding(AdAcademicStanding.KB);
        admission2.setOrdinal(2);
        admission2.setGpa(BigDecimal.ZERO);
        admission2.setCgpa(BigDecimal.ZERO);
        admission2.setCreditEarned(0);
        admission2.setCreditTaken(0);
        admission2.setCohort(plannerService.findCohortByCode("MGSEB-MBA-CHRT-001"));
        termService.saveAdmission(admission2);
        
        AdOffering offering2 = new AdOfferingImpl();
        offering2.setCanonicalCode("Sem_2_Offering");
        offering2.setCapacity(100);
        offering2.setCode("Sem2");
        offering2.setCourse(plannerService.findCourseByCode("GST5023"));
        offering2.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        offering2.setTitleEn("Sem2");
        offering2.setTitleMs("sem2");
        termService.saveOffering(offering2);
        
        AdSection section2 = new AdSectionImpl();
        section2.setCanonicalCode("Section 2");
        section2.setCapacity(10);
        section2.setCode("Section 1");
        section2.setOrdinal(1);
        section2.setOffering(offering2);
        termService.saveSection(section2);
        
        AdEnrollment enrollment2 = new AdEnrollmentImpl();
        enrollment2.setAdmission(admission2);
        enrollment2.setGradeCode(commonService.findGradeCodeByCode("A"));
        enrollment2.setSection(section2);
        enrollment2.setStanding(AdEnrollmentStanding.HW);
        enrollment2.setStatus(AdEnrollmentStatus.CONFIRMED);
        enrollment2.setTotalScore(BigDecimal.ZERO);
        termService.saveEnrollment(enrollment2);
        
        AdAssessment assessment3 = new AdAssessmentImpl();
        assessment3.setCode("MASTER-MBA-GST5023-Q1");
		assessment3.setCanonicalCode("MASTER-MBA-GST5023-201720182-Q1");
		assessment3.setDescription("Economics & Business Environment");
		assessment3.setOrdinal(0);
		assessment3.setWeight(new BigDecimal(BigInteger.valueOf(40)));
		assessment3.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment3.setType(AdAssessmentType.QUIZ);
		assessment3.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment3.setOffering(offering2);
		termService.addAssessment( offering2, assessment3);
		Assert.notNull(assessment3, "quiz1 is null");
		//LOG Debug Quiz 1
		LOG.debug("QUIZ 1 :========>");
		LOG.debug("QUIZ 1 Category :{}", assessment3.getCategory().name());
		LOG.debug("QUIZ 1 Code :{}", assessment3.getCode());
		LOG.debug("QUIZ 1 Type :{}", assessment3.getType().name());
		LOG.debug("QUIZ 1 TotalScore :{}", assessment3.getTotalScore().byteValueExact());
		LOG.debug("QUIZ 1 Weight :{}", assessment3.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment3, "assessment3 Quiz1 is not setup");
		
		AdGradebook gradebook3 = new AdGradebookImpl();
		gradebook3.setScore(new BigDecimal(BigInteger.valueOf(80)));
		gradebook3.setAssessment(assessment3);
		gradebook3.setEnrollment(enrollment2);
		gradebook3.setSection(section2);
		termService.addGradebook(section2, enrollment2, gradebook3);
		LOG.debug("gradebook Assessment:{}", gradebook3.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook3.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook3.getScore());
		Assert.notNull(gradebook3, "gradebook3 cannot be null");
		
        AdAssessment assessment4 = new AdAssessmentImpl();
        assessment4.setCode("MASTER-MBA-GST5023-Final");
		assessment4.setCanonicalCode("MASTER-MBA-GST5023-201720182-Final");
		assessment4.setDescription("Economics & Business Environment");
		assessment4.setOrdinal(0);
		assessment4.setWeight(new BigDecimal(BigInteger.valueOf(60)));
		assessment4.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment4.setType(AdAssessmentType.FINAL_EXAM);
		assessment4.setCategory(AdAssessmentCategory.EXAM_WORK);
		assessment4.setOffering(offering2);
		termService.addAssessment( offering2, assessment4);
		Assert.notNull(assessment4, "assessment4 Final is null");
		//LOG Debug Quiz 1
		LOG.debug("Final :========>");
		LOG.debug("Final Category :{}", assessment4.getCategory().name());
		LOG.debug("Final Code :{}", assessment4.getCode());
		LOG.debug("Final Type :{}", assessment4.getType().name());
		LOG.debug("Final TotalScore :{}", assessment4.getTotalScore().byteValueExact());
		LOG.debug("Final Weight :{}", assessment4.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment4, "assessment4 Final is not setup");
		
		AdGradebook gradebook4 = new AdGradebookImpl();
		gradebook4.setScore(new BigDecimal(BigInteger.valueOf(40)));
		gradebook4.setAssessment(assessment4);
		gradebook4.setEnrollment(enrollment2);
		gradebook4.setSection(section2);
		termService.addGradebook(section2, enrollment2, gradebook4);
		LOG.debug("gradebook Assessment:{}", gradebook4.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook4.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook4.getScore());
		Assert.notNull(gradebook4, "gradebook4 cannot be null");
        
		termService.calculateGradebook(offering2);
		termService.calculateGPA(admission2);
        
 //=========================================================================================    
 //					SEM 3
 //======================================================================================== 
        AdAdmissionApplication application3 = new AdAdmissionApplicationImpl();
        application3.setOrdinal(1);
        application3.setStudent(identityService.findStudentByMatricNo("A17P006"));
        application3.setAdvisor(identityService.findStaffByIdentityNo("01610B"));
        application3.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        application3.setStudyCenter(commonService.findStudyCenterByCode("A"));
        application3.setSession(plannerService.findAcademicSessionByCode("201720183"));
        application3.setDescription("Sem2 Student");
        application3.setReferenceNo("Sem2");
        termService.saveAdmissionApplication(application3);
        LOG.debug("Student:{}",application3.getStudent().getIdentityNo());
        LOG.debug("Advisor:{}",application3.getAdvisor().getIdentityNo());
        LOG.debug("Program:{}",application3.getProgram().getCode());
        LOG.debug("StudyCenter:{}",application3.getStudyCenter().getCode());
        LOG.debug("Session:{}",application3.getSession().getCode());
        
        AdAdmission admission3 = new AdAdmissionImpl();
        admission3.setStudyCenter(commonService.findStudyCenterByCode("A"));
        admission3.setStudent(identityService.findStudentByMatricNo("A17P006"));
        admission3.setSession(plannerService.findAcademicSessionByCode("201720183"));
        admission3.setStatus(AdAdmissionStatus.REGULAR);
        admission3.setStanding(AdAcademicStanding.KB);
        admission3.setOrdinal(2);
        admission3.setGpa(BigDecimal.ZERO);
        admission3.setCgpa(BigDecimal.ZERO);
        admission3.setCreditEarned(0);
        admission3.setCreditTaken(0);
        admission3.setCohort(plannerService.findCohortByCode("MGSEB-MBA-CHRT-001"));
        termService.saveAdmission(admission3);
        
        AdOffering offering3 = new AdOfferingImpl();
        offering3.setCanonicalCode("Sem_3_Offering");
        offering3.setCapacity(100);
        offering3.setCode("Sem3");
        offering3.setCourse(plannerService.findCourseByCode("GST5063"));
        offering3.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        offering3.setTitleEn("Sem3");
        offering3.setTitleMs("sem3");
        termService.saveOffering(offering3);
        
        AdSection section3 = new AdSectionImpl();
        section3.setCanonicalCode("Section 3");
        section3.setCapacity(10);
        section3.setCode("Section 1");
        section3.setOrdinal(1);
        section3.setOffering(offering3);
        termService.saveSection(section3);
        
        AdEnrollment enrollment3 = new AdEnrollmentImpl();
        enrollment3.setAdmission(admission3);
        enrollment3.setGradeCode(commonService.findGradeCodeByCode("A"));
        enrollment3.setSection(section3);
        enrollment3.setStanding(AdEnrollmentStanding.HW);
        enrollment3.setStatus(AdEnrollmentStatus.CONFIRMED);
        enrollment3.setTotalScore(BigDecimal.ZERO);
        termService.saveEnrollment(enrollment3);
        
        AdAssessment assessment5 = new AdAssessmentImpl();
        assessment5.setCode("MASTER-MBA-GST5063-Q1");
		assessment5.setCanonicalCode("MASTER-MBA-GST5063-201720183-Q1");
		assessment5.setDescription("Economics & Business Environment");
		assessment5.setOrdinal(0);
		assessment5.setWeight(new BigDecimal(BigInteger.valueOf(40)));
		assessment5.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment5.setType(AdAssessmentType.QUIZ);
		assessment5.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment5.setOffering(offering3);
		termService.addAssessment( offering3, assessment5);
		Assert.notNull(assessment5, "quiz1 is null");
		//LOG Debug Quiz 1
		LOG.debug("QUIZ 1 :========>");
		LOG.debug("QUIZ 1 Category :{}", assessment5.getCategory().name());
		LOG.debug("QUIZ 1 Code :{}", assessment5.getCode());
		LOG.debug("QUIZ 1 Type :{}", assessment5.getType().name());
		LOG.debug("QUIZ 1 TotalScore :{}", assessment5.getTotalScore().byteValueExact());
		LOG.debug("QUIZ 1 Weight :{}", assessment5.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment5, "assessment5 Quiz1 is not setup");
		
		AdGradebook gradebook5 = new AdGradebookImpl();
		gradebook5.setScore(new BigDecimal(BigInteger.valueOf(60)));
		gradebook5.setAssessment(assessment5);
		gradebook5.setEnrollment(enrollment3);
		gradebook5.setSection(section3);
		termService.addGradebook(section3, enrollment3, gradebook5);
		LOG.debug("gradebook Assessment:{}", gradebook5.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook5.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook5.getScore());
		Assert.notNull(gradebook5, "gradebook5 cannot be null");
		
        AdAssessment assessment6 = new AdAssessmentImpl();
        assessment6.setCode("MASTER-MBA-GST5063-Final");
		assessment6.setCanonicalCode("MASTER-MBA-GST5063-201720183-Final");
		assessment6.setDescription("Economics & Business Environment");
		assessment6.setOrdinal(0);
		assessment6.setWeight(new BigDecimal(BigInteger.valueOf(60)));
		assessment6.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment6.setType(AdAssessmentType.FINAL_EXAM);
		assessment6.setCategory(AdAssessmentCategory.EXAM_WORK);
		assessment6.setOffering(offering3);
		termService.addAssessment( offering3, assessment6);
		Assert.notNull(assessment6, "assessment6 Final is null");
		//LOG Debug Quiz 1
		LOG.debug("Final :========>");
		LOG.debug("Final Category :{}", assessment6.getCategory().name());
		LOG.debug("Final Code :{}", assessment6.getCode());
		LOG.debug("Final Type :{}", assessment6.getType().name());
		LOG.debug("Final TotalScore :{}", assessment6.getTotalScore().byteValueExact());
		LOG.debug("Final Weight :{}", assessment6.getWeight().toBigInteger());
		LOG.debug("");
		Assert.notNull(assessment6, "assessment6 Final is not setup");

		AdGradebook gradebook6 = new AdGradebookImpl();
		gradebook6.setScore(new BigDecimal(BigInteger.valueOf(70)));
		gradebook6.setAssessment(assessment6);
		gradebook6.setEnrollment(enrollment3);
		gradebook6.setSection(section3);
		termService.addGradebook(section3, enrollment3, gradebook6);
		LOG.debug("gradebook Assessment:{}", gradebook6.getAssessment().getCanonicalCode());
		LOG.debug("gradebook Enrollee:{}", gradebook6.getEnrollment().getAdmission().getStudent().getName());
		LOG.debug("gradebook Score:{}", gradebook6.getScore());
		Assert.notNull(gradebook6, "gradebook6 cannot be null");
		
		termService.calculateGradebook(offering3);
		termService.calculateGPA(admission3);
               

        academicSessions.forEach(a -> {
            String format = "AcademicSession {} {} has {} applications";

            applications = termService.findAdmissionApplications(a);
            Object[] array = {a.getCode(), a.getSemester(), applications.size()};
            LOG.debug(format, array);
        });


        return self();
    }
    

}