package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdBundleSubject;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPart;
import my.edu.umk.pams.academic.planner.model.AdBundleSubjectPartImpl;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenSetupBundleSubjectPart extends Stage<WhenSetupBundleSubjectPart> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddProgramLevel.class);

	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private List<AdOffering> offerings;

	@ProvidedScenarioState
	private List<AdCourse> course;

	@ExpectedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private List<AdBundleSubjectPart> parts;
@Pending
	public WhenSetupBundleSubjectPart I_setup_bundle_subject_part_$(String PROGRAM_CODE) {
		
		program = plannerService.findProgramByCode(code);
		
		course= plannerService.findCourses(faculty);
		
		for (AdCourse courses : course) {
			
			
			LOG.debug("==================view details offered course===================");
			LOG.debug("title for this program: {}", courses.getCode());
			LOG.debug("courses for this program : {}", courses.getCredit());
			
			
		}
		
		
		

	
		
		return self();
	}
}
