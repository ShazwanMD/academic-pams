package my.edu.umk.pams.academic.studyplan.stage;

import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.offering.stage.ThenTheOfferingIsReadyForSetup;
import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;


@JGivenStage
public class ThenGroupScheduleByIntakeCode extends Stage<ThenGroupScheduleByIntakeCode> {

		public ThenGroupScheduleByIntakeCode group_students_in_the_schedule_by_intake_code() {
		        return self();
		
			
	//		 List<AdCohort> cohort = studyplanService.findCohort(program);
	//	        Assert.notEmpty(cohort);
	//	        return self();
		
		}
}
