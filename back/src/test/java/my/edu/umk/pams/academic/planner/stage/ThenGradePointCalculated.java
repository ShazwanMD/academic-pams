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
import java.util.Arrays;
import java.util.List;

@JGivenStage
public class ThenGradePointCalculated extends Stage<ThenGradePointCalculated> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenGradePointCalculated.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    @ExpectedScenarioState
    private List<AdAdmission> admissions;

    public ThenGradePointCalculated grade_point_is_calculated() {
        Assert.notEmpty(admissions, "admissions cannot be empty");

        admissions.forEach(admission -> {
            List<AdEnrollment> enrollmentsByAdmission = termService.findEnrollments(admission);
            LOG.debug("Found {} enrollmentsByAdmission ->", enrollmentsByAdmission.size());
            enrollmentsByAdmission.forEach(e -> {
                AdAcademicSession session = admission.getSession();
                AdSection section = e.getSection();
                AdStudent student = admission.getStudent();
                String studentMatricNo = student.getMatricNo() + " " + student.getName();
                BigDecimal GPA_EXPECTED = admission.getGpa();   // todo(sam) changeme
                BigDecimal GPA_ACTUAL = admission.getGpa();
                BigDecimal CGPA_EXPECTED = admission.getCgpa(); // todo(sam) changeme
                BigDecimal CGPA_ACTUAL = admission.getCgpa();

                String format = "-Admission {}, Session {}, Section {}, Student {} {}g {}cg";
                Object[] array = {admission.getId(), session.getCode(), section.getCanonicalCode(), studentMatricNo, GPA_ACTUAL, CGPA_ACTUAL};
                LOG.debug(format, array);

                String GPA_MSG = "Expected GPA " + GPA_EXPECTED + " but found " + GPA_ACTUAL;
                String CGPA_MSG = "Expected CGPA " + CGPA_EXPECTED + " but  found " + CGPA_ACTUAL;

                Assert.isTrue(GPA_EXPECTED.equals(GPA_ACTUAL), GPA_MSG);
                Assert.isTrue(CGPA_EXPECTED.equals(CGPA_ACTUAL), CGPA_MSG);

            });
        });

        return self();
    }
}
