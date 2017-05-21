package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdVenueCode;
import my.edu.umk.pams.academic.common.model.AdVenueCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;

@JGivenStage
public class WhenIAmSetupExamVivaInfo extends Stage<WhenIAmSetupExamVivaInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAmSetupExamVivaInfo.class);

    @Autowired
    private CommonService commonService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    @ProvidedScenarioState
    private AdCourse course;

    @ProvidedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private static String staffMgseb;

    @ProvidedScenarioState
    private AdStaff staff;

    @ProvidedScenarioState
    private AdSection section;

    @ProvidedScenarioState
    private AdAssessment assessment;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdOffering offering;

    @ExpectedScenarioState
    private static String staffCps;

    @ProvidedScenarioState
    private AdVenueCode venue;

    public WhenIAmSetupExamVivaInfo i_setup_assessment_info() {

        staff = identityService.findStaffByStaffNo(staffMgseb);
        LOG.debug("Staff name :{}", staff.getName());
        LOG.debug("Staff Type :{}", staff.getStaffType().name());
        LOG.debug("");

        program = staff.getProgram();
        faculty = staff.getFaculty();
        LOG.debug("Faculty :{}", faculty.getName());
        course = plannerService.findCourseByCodeAndFaculty("GST5023", faculty);
        LOG.debug("Course :{}", course.getTitleMs());
        LOG.debug("");

        offering = termService.findOfferingByProgramAndCourse(program, course);
        LOG.debug("Offering :{}", offering);

        section = termService.findSectionByCanonicalCode("MGSEB-MBA-GST5023-201720181-01");
        LOG.debug("Section:{}", section.getCanonicalCode());


        //Quiz 1
        assessment = new AdAssessmentImpl();
        assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/Q1");
        assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
        assessment.setCode("MASTER/MBA/GST503/Q1");
        assessment.setType(AdAssessmentType.QUIZ);
        assessment.setDescription("Economics & Environment");
        assessment.setOrdinal(0);
        assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
        assessment.setWeight(new BigDecimal(BigInteger.valueOf(10)));
        assessment.setOffering(offering);
        termService.addAssessment(offering, assessment);

        Assert.notNull(assessment, "quiz1 is null");

        venue = new AdVenueCodeImpl();
        venue.setCode("Blok A");
        venue.setDescription("Bilik Kuliah Blok A");
        LOG.debug("Venue Code :{}", venue.getCode());
        LOG.debug("Venue Desc :{}", venue.getDescription());
        LOG.debug("");


        commonService.saveVenueCode(venue);


        //Test 1
        assessment = new AdAssessmentImpl();
        assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/T1");
        assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
        assessment.setCode("MASTER/MBA/GST5013/T1");
        assessment.setType(AdAssessmentType.TEST);
        assessment.setDescription("Economics & Environment");
        assessment.setOrdinal(0);
        assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
        assessment.setWeight(new BigDecimal(BigInteger.valueOf(20)));
        assessment.setOffering(offering);
        termService.addAssessment(offering, assessment);

        Assert.notNull(assessment, "test1 is null");

        //Final Exam
        assessment = new AdAssessmentImpl();
        assessment.setCanonicalCode("MASTER/MBA/GST5013/201720181/F1");
        assessment.setCategory(AdAssessmentCategory.EXAM_WORK);
        assessment.setCode("MASTER/MBA/GST5013/F1");
        assessment.setType(AdAssessmentType.FINAL_EXAM);
        assessment.setDescription("Economics & Environment");
        assessment.setOrdinal(0);
        assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
        assessment.setWeight(new BigDecimal(BigInteger.valueOf(20)));
        assessment.setOffering(offering);
        termService.addAssessment(offering, assessment);

        Assert.notNull(assessment, "Final Exam is null");
        return self();
    }

    public WhenIAmSetupExamVivaInfo i_setup_viva() {
        staff = identityService.findStaffByStaffNo(staffCps);
        LOG.debug("Staff name :{}", staff.getName());
        LOG.debug("Staff Type :{}", staff.getStaffType().name());

        faculty = staff.getFaculty();
        LOG.debug("Faculty :{}", faculty.getName());
        LOG.debug("");
        program = staff.getProgram();
        LOG.debug("Program :{}", program.getTitleEn());
        LOG.debug("Program :{}", program.getTitleMs());
        LOG.debug("");

        course = plannerService.findCourseByCodeAndFaculty("MDP", faculty);
        LOG.debug("Course :{}", course.getTitleMs());
        LOG.debug("");
        assessment = new AdAssessmentImpl();
        assessment.setCanonicalCode("MASTER/MDP/201720181/Viva");
        assessment.setCategory(AdAssessmentCategory.EXAM_WORK);
        assessment.setCode("MASTER/MDP/Viva");
        assessment.setType(AdAssessmentType.VIVA);
        assessment.setDescription("PATALOGY");
        assessment.setOrdinal(0);
        assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
        assessment.setWeight(new BigDecimal(BigInteger.valueOf(45)));
        assessment.setOffering(offering);
        termService.addAssessment(offering, assessment);

        Assert.notNull(assessment, "Viva is null");


        return self();

    }

}
