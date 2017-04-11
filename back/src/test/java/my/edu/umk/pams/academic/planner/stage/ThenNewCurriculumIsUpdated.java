package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.planner.model.AdCurriculum;

public class ThenNewCurriculumIsUpdated extends Stage<ThenNewCurriculumIsUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenNewCurriculumIsUpdated.class);

	@ExpectedScenarioState
	private AdCurriculum curriculum;

	public ThenNewCurriculumIsUpdated new_curriculum_is_updated() {

		LOG.debug("Curriculum has been updated: {} ", curriculum.getCode());
		Assert.notNull(curriculum, "curriculum data has been updated");

		return self();
	}

}
