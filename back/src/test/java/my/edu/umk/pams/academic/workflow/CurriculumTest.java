package my.edu.umk.pams.academic.workflow;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
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

/**
 * @author PAMS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class CurriculumTest {

    private static final Logger LOG = LoggerFactory.getLogger(CurriculumTest.class);

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

    @Test
    @Rollback(false)
    public void testWorkflow() {
        AdCurriculum curriculum = new AdCurriculumImpl();
        curriculum.setCode("ABC123");
        curriculum.setCoreCredit(10);
        curriculum.setCurriculumCredit(10);
        plannerService.saveCurriculum(curriculum);
        curriculum = plannerService.findCurriculumByCode("ABC123");

        // single subject
        AdSingleSubject subject = new AdSingleSubjectImpl();
        subject.setCourse(plannerService.findCourseByCode("GST2113"));
        subject.setPeriod(AdAcademicPeriod.I);
        subject.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject);

        // elective/bundle subject
        AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
        bundleSubject.setSubjectType(AdSubjectType.ELECTIVE);
        bundleSubject.setPeriod(AdAcademicPeriod.II);
        plannerService.addSubject(curriculum, bundleSubject);

        // prepare part
        AdBundleSubjectPart part1 = new AdBundleSubjectPartImpl();
        part1.setCourse(plannerService.findCourseByCode("GST2113"));
        AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
        part2.setCourse(plannerService.findCourseByCode("GST2113"));
        plannerService.addSubjectPart(bundleSubject, part1);
        plannerService.addSubjectPart(bundleSubject, part2);

    }
}
