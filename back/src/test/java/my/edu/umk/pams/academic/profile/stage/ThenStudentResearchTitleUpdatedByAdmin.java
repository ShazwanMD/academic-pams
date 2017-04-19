package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenStudentResearchTitleUpdatedByAdmin extends Stage<ThenStudentResearchTitleUpdatedByAdmin> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentResearchTitleUpdatedByAdmin.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private AdFaculty faculty;

	public ThenStudentResearchTitleUpdatedByAdmin Student_research_title_updated_by_admin_cps() {
		faculty = plannerService.findFacultyByCode("CPS");
		Assert.notNull(faculty, "Faculty Must Not NULL");
		course = plannerService.findCourseByCode("FKP/MASTER/MAP1.1");
		Assert.notNull(course, "Course Must Not NULL");

		boolean exists = plannerService.isCourseExists("FKP/MASTER/MAP1.1", faculty);
		Assert.isTrue(exists, "course FKP/MASTER/MAP1.1 is not exists");

		return self();

	}

	public ThenStudentResearchTitleUpdatedByAdmin Student_research_title_updated_by_admin_mgseb() {
		faculty = plannerService.findFacultyByCode("A10");
		Assert.notNull(faculty, "Faculty Must Not NULL");
		course = plannerService.findCourseByCode("DBA/YEAR3/SEMESTER6/Module 14");
		Assert.notNull(course, "Course Must Not NULL");

		boolean exists = plannerService.isCourseExists("DBA/YEAR3/SEMESTER6/Module 14", faculty);
		Assert.isTrue(exists, "Course DBA/YEAR3/SEMESTER6/Module 14 is not exists");

		return self();

	}

}
