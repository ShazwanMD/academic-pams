
package my.edu.umk.pams.academic.workflow;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplicationImpl;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
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

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class GraduationApplicationWorkflowTest {

    private static final Logger LOG = LoggerFactory.getLogger(GraduationApplicationWorkflowTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private GraduationService graduationService;

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
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("bursary", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

    /**
     * NOTE: graduation application has 3 layers of workflow
     * NOTE: DRAFTED > REGISTERED > VERIFIED > APPROVED
     */
    @Test
    @Rollback
    public void testWorkflow() {
        // find account
        AdStudent student = identityService.findStudentByMatricNo("A17P001");
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();

        // create graduation application then start workflow
        // transition to DRAFTED
        AdGraduationApplication application = new AdGraduationApplicationImpl();
        application.setDescription("GRADUATION APPLICATION");
        application.setStudent(student);
        application.setSession(academicSession);
        application.setCreditHour(15);
        application.setMemo(" BOLEH LEPAS");
        String referenceNo = graduationService.startGraduationApplicationTask(application);
        LOG.debug("graduation application is started with referenceNo {}", referenceNo);

        // find and pick assigned drafted invoice
        // assuming there is one
        List<Task> draftedTasks = graduationService.findAssignedGraduationApplicationTasks(0, 100);
        Assert.notEmpty(draftedTasks, "Tasks should not be empty");
        Task draftedTask = draftedTasks.get(0);
        AdGraduationApplication draftedApplication = graduationService.findGraduationApplicationByTaskId(draftedTask.getId());

        // fill in the rest of the information
        draftedApplication.setCgpa(BigDecimal.valueOf(3.99));
        draftedApplication.setCreditHour(15);
        draftedApplication.setMemo(" BOLEH LEPAS");

        // we're done, let's submit drafted task
        // transition to REGISTERED
        workflowService.completeTask(draftedTask);

        // PEGAWAI CPS/MGSEB
        // find and pick pooled registered invoice
        // assuming there is exactly one
        List<Task> pooledRegisteredInvoices = graduationService.findPooledGraduationApplicationTasks(0, 100);
        Assert.notEmpty(pooledRegisteredInvoices, "Tasks should not be empty");
        workflowService.assignTask(pooledRegisteredInvoices.get(0));

        // find and complete assigned registered invoice
        // assuming there is exactly one
        // transition to VERIFIED
        List<Task> assignedRegisteredInvoices = graduationService.findAssignedGraduationApplicationTasks(0, 100);
        Assert.notEmpty(assignedRegisteredInvoices, "Tasks should not be empty");
        workflowService.completeTask(assignedRegisteredInvoices.get(0));

        // PENDAFTAR
        // find and pick pooled verified invoice
        // assuming there is exactly one
        List<Task> pooledVerifiedInvoices = graduationService.findPooledGraduationApplicationTasks(0, 100);
        Assert.notEmpty(pooledVerifiedInvoices, "Tasks should not be empty");
        workflowService.assignTask(pooledVerifiedInvoices.get(0));

        // find and complete assigned verified invoice
        // assuming there is exactly one
        // transition to APPROVED (COMPLETED)
        List<Task> assignedVerifiedInvoices = graduationService.findAssignedGraduationApplicationTasks(0, 100);
        Assert.notEmpty(assignedVerifiedInvoices, "Tasks should not be empty");
        workflowService.completeTask(assignedVerifiedInvoices.get(0)); // TO APPROVE
    }
}
