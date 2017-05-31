package my.edu.umk.pams.academic.workflow;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class GradebookTest {

    private static final Logger LOG = LoggerFactory.getLogger(GradebookTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TermService termService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private IdentityService identityService;

    @Before
    public void before() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

    // note: draft > register >> approve
    @Test
    @Rollback(false)
    public void testWorkflow() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        AdStudent a17P001 = identityService.findStudentByMatricNo("A17P001");
        AdAdmission admission1 = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, a17P001.getCohort(), a17P001);
        LOG.debug("student: {}", a17P001.getId());
        LOG.debug("cohort: {}", a17P001.getCohort().getCode());
        LOG.debug("admission: {}", admission1.getId());

        AdStudent a17P002 = identityService.findStudentByMatricNo("A17P001");
        AdAdmission admission2 = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, a17P002.getCohort(), a17P002);
        LOG.debug("student: {}", a17P002.getId());
        LOG.debug("cohort: {}", a17P002.getCohort().getCode());
        LOG.debug("admission: {}", admission2.getId());

        AdStudent student1 = identityService.findStudentByMatricNo("A17P001");
        enroll(student1);
        AdStudent student2 = identityService.findStudentByMatricNo("A17P002");
        enroll(student2);
    }

    private void enroll(AdStudent student) {
        AdCohort cohort = student.getCohort(); // current cohort
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        AdAdmission admission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, cohort, student);
        LOG.debug("admission: {}", admission.getId());

        AdEnrollmentApplication application = new AdEnrollmentApplicationImpl();
        application.setDescription(student.getMatricNo() + ";" + student.getCohort().getCode());
        application.setSession(academicSession);
        application.setAdmission(admission);
        application.setType(AdEnrollmentApplicationType.WAJIB);
        String referenceNo = termService.startEnrollmentApplicationTask(application);
        LOG.debug("Enrollment Application is created with referenceNo {}", referenceNo);

        // find and pick assigned drafted application
        // assuming there is one
        List<Task> draftedTasks = termService.findAssignedEnrollmentApplicationTasks(0, 100);
        Assert.notEmpty(draftedTasks, "Tasks should not be empty");
        Task draftedTask = draftedTasks.get(0);
        AdEnrollmentApplication draftedApplication = termService.findEnrollmentApplicationByTaskId(draftedTask.getId());

        // add items to application
        AdEnrollmentApplicationItem item1 = new AdEnrollmentApplicationItemImpl();
        item1.setAction(AdEnrollmentApplicationAction.ADD);
        item1.setSection(termService.findSectionByCanonicalCode("MGSEB-MBA-GST5023-201720181-01"));
        termService.addEnrollmentApplicationItem(draftedApplication, item1);

        AdEnrollmentApplicationItem item2 = new AdEnrollmentApplicationItemImpl();
        item2.setAction(AdEnrollmentApplicationAction.ADD);
        item2.setSection(termService.findSectionByCanonicalCode("MGSEB-MBA-GST5023-201720181-02"));
        termService.addEnrollmentApplicationItem(draftedApplication, item2);

        // we're done, let's submit drafted task
        // transition to REGISTERED
        workflowService.completeTask(draftedTask);
    }
}
