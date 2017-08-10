package my.edu.umk.pams.academic;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdEmailQueue;
import my.edu.umk.pams.academic.system.model.AdEmailQueueImpl;
import my.edu.umk.pams.academic.system.model.AdEmailQueueStatus;
import my.edu.umk.pams.academic.system.service.SystemService;

@JGivenStage
public class TestEmail extends Stage<TestEmail> {

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SystemService systemService;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdProgram program;

	private String facultycode;

	private static final Logger LOG = LoggerFactory.getLogger(TestEmail.class);

    public void emailTest() {

    	 AdEmailQueue emailQueue = new AdEmailQueueImpl();
         emailQueue.setCode("abc123");
         emailQueue.setTo("asyikin.mr@umk.edu.my");
         emailQueue.setSubject("in process");
         emailQueue.setQueueStatus(AdEmailQueueStatus.QUEUED);
         emailQueue.setBody("testing to email asyikin in process");
         emailQueue.setRetryCount(1);
         LOG.debug("test1: {}", emailQueue);
     
         systemService.saveEmailQueue(emailQueue);
         LOG.debug("test2: {}", emailQueue);
    }
}
