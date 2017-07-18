package my.edu.umk.pams.academic.workflow;

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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPart;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPartImpl;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdCurriculumImpl;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdSingleSubject;
import my.edu.umk.pams.academic.planner.model.AdSingleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdSubject;
import my.edu.umk.pams.academic.planner.model.AdSubjectType;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class CurriculumBundleTest {

    private static final Logger LOG = LoggerFactory.getLogger(CurriculumBundleTest.class);

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

    private AdProgram program;

    private List<AdSubject> subjects;

    private AdCourse course;

    private AdSubjectType subjectType;

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
        String code = "bcdefg" + System.currentTimeMillis();
        curriculum.setCode(code);
        curriculum.setCoreCredit(10);
        curriculum.setCurriculumCredit(10);
        curriculum.setElectiveCredit(10);
        curriculum.setGeneralCredit(10);
        curriculum.setLanguageCredit(10);
        curriculum.setMaxPeriod(10);
        curriculum.setOrdinal(10);
        curriculum.setOthersCredit(10);
        curriculum.setPeriod(10);
        curriculum.setProgram(plannerService.findProgramByCode("FIAT-PHD-PBT"));
        curriculum.setRequiredCredit(0);
        curriculum.setSubjects(subjects);
        curriculum.setTotalCredit(10);
        plannerService.saveCurriculum(curriculum);
        curriculum = plannerService.findCurriculumByCode(code);
        LOG.debug("code: {}", curriculum.getCode());

        // test single
        AdSingleSubject subject11 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5013"));
        subject11.setOrdinal(1); // semester 1
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject11);

        AdSingleSubject subject12 = new AdSingleSubjectImpl();
        subject12.setCourse(plannerService.findCourseByCode("GST5023"));
        subject12.setOrdinal(1); // semester 1
        subject12.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject12);

        AdSingleSubject subject13 = new AdSingleSubjectImpl();
        subject13.setCourse(plannerService.findCourseByCode("GST5063"));
        subject13.setOrdinal(1); // semester 1
        subject13.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject13);

        AdSingleSubject subject14 = new AdSingleSubjectImpl();
        subject14.setCourse(plannerService.findCourseByCode("GST5043"));
        subject14.setOrdinal(1); // semester 1
        subject14.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject14);

        AdSingleSubject subject15 = new AdSingleSubjectImpl();
        subject15.setCourse(plannerService.findCourseByCode("GST5053"));
        subject15.setOrdinal(1); // semester 1
        subject15.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject15);




        // test bundle

        // elective/bundle subject // core elective
        AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
        bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
        bundleSubject.setOrdinal(1);
        plannerService.addSubject(curriculum, bundleSubject);
        AdBundleSubject addedBundleSubject = (AdBundleSubject)
                plannerService.findSubject(curriculum, AdSubjectType.CORE_ELECTIVE, 1);
        LOG.debug("code: {}", addedBundleSubject.getId());

        // prepare part //PENGKHUSUSAN (ENTREPRENEURSHIP)
        AdBundleSubjectPart part31 = new AdBundleSubjectPartImpl();
        part31.setCourse(plannerService.findCourseByCode("GSK6153"));
        AdBundleSubjectPart part32 = new AdBundleSubjectPartImpl();
        part32.setCourse(plannerService.findCourseByCode("GSK6163"));
        AdBundleSubjectPart part33 = new AdBundleSubjectPartImpl();
        part33.setCourse(plannerService.findCourseByCode("GSK6173"));

        plannerService.addSubjectPart(addedBundleSubject, part31);
        plannerService.addSubjectPart(addedBundleSubject, part32);
        plannerService.addSubjectPart(addedBundleSubject, part33);
    }
}
