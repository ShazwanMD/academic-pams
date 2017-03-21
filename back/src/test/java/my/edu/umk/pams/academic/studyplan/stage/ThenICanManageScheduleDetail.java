package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.annotation.Pending;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

public class ThenICanManageScheduleDetail extends Stage<ThenICanManageScheduleDetail> {


	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private String code;

	private boolean exists;

	@Pending
	public ThenICanManageScheduleDetail I_can_manage_schedule_detail() {

		return self();
	}
}
