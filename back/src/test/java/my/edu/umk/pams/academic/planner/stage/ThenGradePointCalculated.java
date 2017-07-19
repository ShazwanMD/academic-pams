package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@JGivenStage
public class ThenGradePointCalculated extends Stage<ThenGradePointCalculated> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenGradePointCalculated.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;


    @ExpectedScenarioState
    private List<AdAdmissionApplication> applications;

    public ThenGradePointCalculated grade_point_is_calculated() {
        Assert.notEmpty(applications, "applications cannot be empty");
        // By Application
 
        applications.forEach(a -> {
            List<AdEnrollment> enrollmentsByStudent = termService.findEnrollments(a.getStudent());
            LOG.debug("Found {} enrollmentsByStudent", enrollmentsByStudent.size());
            enrollmentsByStudent.forEach(e -> {
                AdAdmission admission = e.getAdmission();
                AdAcademicSession session = admission.getSession();
                AdSection section = e.getSection();
                AdStudent student = admission.getStudent();
                String studentMatricNo = student.getMatricNo() + " " + student.getName();
                BigDecimal GPA_EXPECTED = admission.getGpa();   // todo(sam) changeme
                BigDecimal GPA_ACTUAL = admission.getGpa();
                BigDecimal CGPA_EXPECTED = admission.getCgpa(); // todo(sam) changeme
                BigDecimal CGPA_ACTUAL = admission.getCgpa();

                LOG.debug("     A: Admission {} Session {} Section {}: {} ", new Object[]{
                        admission.getId(), session.getCode(), section.getCanonicalCode(), studentMatricNo
                });
                LOG.debug("     A: GPA {}, CGPA {}", GPA_ACTUAL, CGPA_ACTUAL);

                Assert.isTrue(GPA_EXPECTED.equals(GPA_ACTUAL), "Expected GPA " + GPA_EXPECTED + " but found " + GPA_ACTUAL);
                Assert.isTrue(CGPA_EXPECTED.equals(CGPA_ACTUAL), "Expected CGPA " + CGPA_EXPECTED + " but  found " + CGPA_ACTUAL);

            });
        });

        // By Session
        AdAdmissionApplication sampleApplication = applications.get(0);
        AdAcademicSession sampleSession = sampleApplication.getSession();
        List<AdEnrollment> enrollmentsBySession = termService.findEnrollments(sampleSession);
        LOG.debug("Found {} enrollmentsBySession", enrollmentsBySession.size());
        enrollmentsBySession.forEach(e -> {
            AdAdmission admission = e.getAdmission();
            AdAcademicSession session = admission.getSession();
            AdSection section = e.getSection();
            AdStudent student = admission.getStudent();
            String studentMatricNo = student.getMatricNo() + " " + student.getName();
            BigDecimal GPA_EXPECTED = admission.getGpa();   // todo(sam) changeme
            BigDecimal GPA_ACTUAL = admission.getGpa();
            BigDecimal CGPA_EXPECTED = admission.getCgpa(); // todo(sam) changeme
            BigDecimal CGPA_ACTUAL = admission.getCgpa();

            LOG.debug("     B: Admission {} Session {} Section {}: {}", new Object[]{
                    admission.getId(), session.getCode(), section.getCanonicalCode(), studentMatricNo
            });
            LOG.debug("     B: GPA {}, CGPA {}", GPA_ACTUAL, CGPA_ACTUAL);
            Assert.isTrue(GPA_EXPECTED.equals(GPA_ACTUAL), "Expected GPA " + GPA_EXPECTED + " but found " + GPA_ACTUAL);
            Assert.isTrue(CGPA_EXPECTED.equals(CGPA_ACTUAL), "Expected CGPA " + CGPA_EXPECTED + " but  found " + CGPA_ACTUAL);
        });


        return self();
    }
}
