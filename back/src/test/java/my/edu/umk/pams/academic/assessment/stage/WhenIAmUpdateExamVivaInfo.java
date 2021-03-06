package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@JGivenStage
public class WhenIAmUpdateExamVivaInfo extends Stage<WhenIAmUpdateExamVivaInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateExamVivaInfo.class);

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ProvidedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdOfferingDao offeringDao;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdUser user;

	public WhenIAmUpdateExamVivaInfo i_update_examination_info() throws Exception {

		offering = new AdOfferingImpl();
		offering.setCanonicalCode("FIAT/MASTER/PBH/GST5060");
		offering.setCapacity(100);
		offering.setCode("GST5060");
		offering.setTitleMs("MECHANICS OF MATERIALS");
		offering.setTitleEn("MECHANICS OF MATERIALS");
		offering.setProgram(program);

		termService.saveOffering(offering);

		assessment = new AdAssessmentImpl();
		assessment.setCanonicalCode("FIAT/MASTER/PBH/GST5060");
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setCode("MASTER/PBH");
		assessment.setDescription("MECHANICS OF MATERIALS");
		assessment.setOffering(offering);
		assessment.setOrdinal(0);
		assessment.setTotalScore(BigDecimal.ONE);
		assessment.setType(AdAssessmentType.QUIZ);
		assessment.setWeight(BigDecimal.ONE);
		termService.addAssessment(offering, assessment);

		Assert.notNull(assessment, "assesment is empty");

		return self();

	}

	@Pending
	public WhenIAmUpdateExamVivaInfo i_update_viva_info() {

		return self();

	}

}
