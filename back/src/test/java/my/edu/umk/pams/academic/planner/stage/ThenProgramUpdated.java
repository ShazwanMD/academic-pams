package my.edu.umk.pams.academic.planner.stage;

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

@JGivenStage
public class ThenProgramUpdated extends Stage<ThenProgramUpdated> {

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdProgram program;

	private String facultycode;

	private static final Logger LOG = LoggerFactory.getLogger(ThenProgramUpdated.class);

	public ThenProgramUpdated program_is_updated() {


		AdProgram program = plannerService.findProgramByCode(facultycode);
		Assert.isNull(program, "The data must null");

		return self();

	}

}
