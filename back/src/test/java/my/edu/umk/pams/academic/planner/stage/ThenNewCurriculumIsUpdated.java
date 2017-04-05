package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;

public class ThenNewCurriculumIsUpdated extends Stage<ThenNewCurriculumIsUpdated> {

	
	private static final Logger LOG = LoggerFactory.getLogger(ThenNewCurriculumIsUpdated.class);
	public ThenNewCurriculumIsUpdated new_curriculum_is_updated() {

	
		return self();
	}

}
