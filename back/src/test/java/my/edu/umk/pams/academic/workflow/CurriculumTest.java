package my.edu.umk.pams.academic.workflow;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;

import java.util.List;

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

/**
 * @author PAMS
 */
@RunWith(SpringRunner.class)
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
        curriculum.setCode("ainmj");
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
        curriculum = plannerService.findCurriculumByCode("abcfffssyy");
      LOG.debug("code{}",curriculum.getCode());
      

      //   ================================
     //    SEMESTER 1
       //  ================================
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
        
        // ================================
        // SEMESTER 2
        // ================================
        AdSingleSubject subject21 = new AdSingleSubjectImpl();
        subject21.setCourse(plannerService.findCourseByCode("GST5033"));
        subject21.setOrdinal(1); // semester 1
        subject21.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject21);

  
        AdSingleSubject subject22 = new AdSingleSubjectImpl();
        subject22.setCourse(plannerService.findCourseByCode("GST5073"));
        subject22.setOrdinal(1); // semester 1
        subject22.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject22);

        AdSingleSubject subject23 = new AdSingleSubjectImpl();
        subject23.setCourse(plannerService.findCourseByCode("GST5083"));
        subject23.setOrdinal(1); // semester 1
        subject23.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject23);

        AdSingleSubject subject24 = new AdSingleSubjectImpl();
        subject24.setCourse(plannerService.findCourseByCode("GST5113"));
        subject24.setOrdinal(1); // semester 1
        subject24.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject24);

        AdSingleSubject subject25 = new AdSingleSubjectImpl();
        subject25.setCourse(plannerService.findCourseByCode("GST5103"));
        subject25.setOrdinal(1); // semester 1
        subject25.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject25);
        
        // ================================
        // SEMESTER 3
        // ================================
        
        
        AdSingleSubject subject31 = new AdSingleSubjectImpl();
        subject31.setCourse(plannerService.findCourseByCode("GST5033"));
        subject31.setOrdinal(1); // semester 1
        subject31.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject31);

        AdSingleSubject subject32 = new AdSingleSubjectImpl();
        subject32.setCourse(plannerService.findCourseByCode("GST5073"));
        subject32.setOrdinal(1); // semester 1
        subject32.setSubjectType(AdSubjectType.CORE); 
        plannerService.addSubject(curriculum, subject32);

        // elective/bundle subject // core elective
        AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
        bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
        bundleSubject.setOrdinal(1);
        plannerService.addSubject(curriculum, bundleSubject);
  
        
     // prepare part //PENGKHUSUSAN (ENTREPRENEURSHIP)
        AdBundleSubjectPart part31 = new AdBundleSubjectPartImpl();
        part31.setCourse(plannerService.findCourseByCode("GSK6153"));
        AdBundleSubjectPart part32 = new AdBundleSubjectPartImpl();
        part32.setCourse(plannerService.findCourseByCode("GSK6163"));
        AdBundleSubjectPart part33 = new AdBundleSubjectPartImpl();
        part33.setCourse(plannerService.findCourseByCode("GSK6173"));
        
        // PENGKHUSUSAN (FINANCE)
        AdBundleSubjectPart part34 = new AdBundleSubjectPartImpl();
        part34.setCourse(plannerService.findCourseByCode("GSK6033"));
        AdBundleSubjectPart part35 = new AdBundleSubjectPartImpl();
        part35.setCourse(plannerService.findCourseByCode("GSK6043"));
    
        
        //PENGKHUSUSAN (MARKETING)
        
        AdBundleSubjectPart part36 = new AdBundleSubjectPartImpl();
        part36.setCourse(plannerService.findCourseByCode("GSK6053"));
        AdBundleSubjectPart part37 = new AdBundleSubjectPartImpl();
        part37.setCourse(plannerService.findCourseByCode("GSK6063"));
      
        
        // PENGKHUSUSAN (HUMAN RESOURCE MANAGEMENT)
        
        AdBundleSubjectPart part38 = new AdBundleSubjectPartImpl();
        part38.setCourse(plannerService.findCourseByCode("GSK6073"));
        AdBundleSubjectPart part39= new AdBundleSubjectPartImpl();
        part39.setCourse(plannerService.findCourseByCode("GSK6083"));
      
        
        plannerService.addSubjectPart(bundleSubject, part31);
        plannerService.addSubjectPart(bundleSubject, part32);
        plannerService.addSubjectPart(bundleSubject, part33);
        plannerService.addSubjectPart(bundleSubject, part34);
        plannerService.addSubjectPart(bundleSubject, part35);
        plannerService.addSubjectPart(bundleSubject, part36);
        plannerService.addSubjectPart(bundleSubject, part37);
        plannerService.addSubjectPart(bundleSubject, part38);
        
        // elective (option)/bundle subject  // option student tp admin dh ttpkan 
        AdBundleSubject bundleSubject1 = new AdBundleSubjectImpl();
        bundleSubject1.setSubjectType(AdSubjectType.ELECTIVE);
        bundleSubject1.setOrdinal(1);
        plannerService.addSubject(curriculum, bundleSubject1);
    
     // prepare part //PENGKHUSUSAN (ENTREPRENEURSHIP)
        AdBundleSubjectPart part = new AdBundleSubjectPartImpl();
        part.setCourse(plannerService.findCourseByCode("GSE6013"));
        
     // PENGKHUSUSAN (FINANCE)
        
        AdBundleSubjectPart part2 = new AdBundleSubjectPartImpl();
        part.setCourse(plannerService.findCourseByCode("GSE6043"));
        
        //PENGKHUSUSAN (MARKETING)
        
        AdBundleSubjectPart part3 = new AdBundleSubjectPartImpl();
        part.setCourse(plannerService.findCourseByCode("GSE6093"));
         
        //PENGKHUSUSAN (HUMAN RESOURCE MANAGEMENT)
        AdBundleSubjectPart part4 = new AdBundleSubjectPartImpl();
        part.setCourse(plannerService.findCourseByCode("GSE6133"));
        
        
        
        
     
    }
}
