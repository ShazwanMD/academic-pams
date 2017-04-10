package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


@JGivenStage
public class ThenProgramInfomationReviewed extends Stage<ThenProgramInfomationReviewed> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramInfomationReviewed.class);
	
	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private String code;

	private boolean exists;

	public ThenProgramInfomationReviewed Program_Infomation_reviewed() {
		

		List<AdProgram> program = plannerService.findPrograms(faculty);
		Assert.notEmpty(program, "programs should not be empty");
		
		
        for (AdProgram programs : program) {
            LOG.debug(programs.getCode());
            Assert.notNull(programs.getCode(), "program code should not be empty");  
        }

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitle());
            Assert.notNull(programs.getTitle(), "programs title should not be empty");
        }

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleEn());
            Assert.notNull(programs.getTitleEn(), "programs titleEn should not be empty");
        }
        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleMs());
            Assert.notNull(programs.getTitleMs(), "programs titleMs should not be empty");
        }
		
		return self();

	}
}
