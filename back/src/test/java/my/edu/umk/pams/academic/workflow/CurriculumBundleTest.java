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
        String code = "MGSEB-MBA-CLM-0001" ;
        //+ System.currentTimeMillis()
        curriculum.setCode(code);
        curriculum.setCoreCredit(100);
        curriculum.setCurriculumCredit(10);
        curriculum.setElectiveCredit(10);
        curriculum.setGeneralCredit(10);
        curriculum.setLanguageCredit(10);
        curriculum.setMaxPeriod(10);
        curriculum.setOrdinal(10);
        curriculum.setOthersCredit(10);
        curriculum.setPeriod(10);
        curriculum.setProgram(plannerService.findProgramByCode("MGSEB-MBA"));
        curriculum.setRequiredCredit(0);
        curriculum.setSubjects(subjects);
        curriculum.setTotalCredit(124);
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
/*
        AdSingleSubject subject21 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5033"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject21);
        
        AdSingleSubject subject22 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5073"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject22);
        
        AdSingleSubject subject23 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5083"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject23);
        
        AdSingleSubject subject24 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5113"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject24);
        
        AdSingleSubject subject25 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5103"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject25);
        
        AdSingleSubject subject31 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5093"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject31);
        
        AdSingleSubject subject32 = new AdSingleSubjectImpl();
        subject11.setCourse(plannerService.findCourseByCode("GST5123"));
        subject11.setOrdinal(1); // semester 2
        subject11.setSubjectType(AdSubjectType.CORE);
        plannerService.addSubject(curriculum, subject32);
        
  */      
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
        AdBundleSubjectPart part34 = new AdBundleSubjectPartImpl();
        part34.setCourse(plannerService.findCourseByCode("GSE6013"));
        
    /*    
        //PENGKHUSUSAN (FINANCE)
        AdBundleSubjectPart part35 = new AdBundleSubjectPartImpl();
        part35.setCourse(plannerService.findCourseByCode("GSK6033"));
        AdBundleSubjectPart part37 = new AdBundleSubjectPartImpl();
        part37.setCourse(plannerService.findCourseByCode("GSK6173"));
        AdBundleSubjectPart part38 = new AdBundleSubjectPartImpl();
        part38.setCourse(plannerService.findCourseByCode("GSE6043"));
        
        //PENGKHUSUSAN (MARKETING)
        
        AdBundleSubjectPart part39 = new AdBundleSubjectPartImpl();
        part39.setCourse(plannerService.findCourseByCode("GSK6053"));
        AdBundleSubjectPart part310 = new AdBundleSubjectPartImpl();
        part310.setCourse(plannerService.findCourseByCode("GSK6063"));
        AdBundleSubjectPart part311 = new AdBundleSubjectPartImpl();
        part311.setCourse(plannerService.findCourseByCode("GSE6093"));
        
       // PENGKHUSUSAN (HUMAN RESOURCE MANAGEMENT)
        
        AdBundleSubjectPart part312 = new AdBundleSubjectPartImpl();
        part312.setCourse(plannerService.findCourseByCode("GSK6073"));
        AdBundleSubjectPart part313 = new AdBundleSubjectPartImpl();
        part313.setCourse(plannerService.findCourseByCode("GSK6083"));
        AdBundleSubjectPart part314 = new AdBundleSubjectPartImpl();
        part314.setCourse(plannerService.findCourseByCode("GSE6133"));
*/
        plannerService.addSubjectPart(addedBundleSubject, part31);
        plannerService.addSubjectPart(addedBundleSubject, part32);
        plannerService.addSubjectPart(addedBundleSubject, part33);
        plannerService.addSubjectPart(addedBundleSubject, part34);
        /*
        plannerService.addSubjectPart(addedBundleSubject, part35);
        plannerService.addSubjectPart(addedBundleSubject, part37);
        plannerService.addSubjectPart(addedBundleSubject, part38);
        plannerService.addSubjectPart(addedBundleSubject, part39);
        plannerService.addSubjectPart(addedBundleSubject, part31);
        plannerService.addSubjectPart(addedBundleSubject, part310);
        plannerService.addSubjectPart(addedBundleSubject, part311);
        plannerService.addSubjectPart(addedBundleSubject, part312);
        plannerService.addSubjectPart(addedBundleSubject, part313);
        plannerService.addSubjectPart(addedBundleSubject, part314);
        */
    }
}
