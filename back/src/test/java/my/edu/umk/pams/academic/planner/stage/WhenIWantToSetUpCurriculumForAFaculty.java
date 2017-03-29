package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * As an admin academic, 
 * i want to set up curriculum for a faculty, 
 * so that i can manage schedule by program.
 * @author zaida
 */

@JGivenStage
public class WhenIWantToSetUpCurriculumForAFaculty extends Stage<WhenIWantToSetUpCurriculumForAFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetUpCurriculumForAFaculty.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdFaculty faculty;

	public WhenIWantToSetUpCurriculumForAFaculty I_want_to_set_up_curriculum_for_a_faculty_$(String code) {

		faculty = plannerService.findFacultyByCode("FKP");

		AdCurriculum Curriculum = new AdCurriculumImpl();

		AdProgram program = plannerService.findProgramByCode("FKP/MASTER/0001/CRLM/0001");

		Curriculum.setCode(code);
		Curriculum.setOrdinal(1);
		Curriculum.setCoreCredit(3);
		Curriculum.setElectiveCredit(3);
		Curriculum.setGeneralCredit(3);
		Curriculum.setRequiredCredit(3);
		Curriculum.setLanguageCredit(3);
		Curriculum.setCurriculumCredit(1);
		Curriculum.setOthersCredit(1);
		Curriculum.setTotalCredit(3);
		Curriculum.setMaxPeriod(5);
		Curriculum.setPeriod(4);
		Curriculum.setProgram(program);

		plannerService.saveCurriculum(Curriculum);

		return self();

	}
}
