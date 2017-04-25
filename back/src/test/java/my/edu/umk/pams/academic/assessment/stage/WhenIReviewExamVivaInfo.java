package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdVenueCode;
import my.edu.umk.pams.academic.common.model.AdVenueCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;

@JGivenStage
public class WhenIReviewExamVivaInfo extends Stage<WhenIReviewExamVivaInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewExamVivaInfo.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ProvidedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdUser user;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

	@ProvidedScenarioState
	private AdStudentStatus studentStatus;

	@ProvidedScenarioState
	private AdVenueCode venue;

	@ExpectedScenarioState
	private String facultyCode;

	public WhenIReviewExamVivaInfo i_review_examination_info() {
		// get Faculty
		faculty = plannerService.findFacultyByCode(facultyCode);
		LOG.debug("Faculty Name :{}", faculty.getName());

		// add venue
		venue = new AdVenueCodeImpl();
		venue.setCode("Dewan Exam 1");
		venue.setDescription("Blok D");
		commonService.saveVenueCode(venue);

		LOG.debug("Venue :{}", venue.getCode());
		LOG.debug("Venue Desc :{}", venue.getDescription());
		LOG.debug("+++++++++++++++++++++++++++++++++++++++++");

		List<AdCourse> courses = faculty.getCourses();
		// view code & credit
		LOG.debug("Course :{}", courses.get(0).getCode());
		LOG.debug("Credit :{}", courses.get(0).getCredit());
		LOG.debug("");
		LOG.debug("Course :{}", courses.get(1).getCode());
		LOG.debug("Credit :{}", courses.get(1).getCredit());
		LOG.debug("");
		LOG.debug("Course :{}", courses.get(2).getCode());
		LOG.debug("Credit :{}", courses.get(2).getCredit());
		LOG.debug("");
		LOG.debug("Course :{}", courses.get(3).getCode());
		LOG.debug("Credit :{}", courses.get(3).getCredit());
		LOG.debug("");
		LOG.debug("Course :{}", courses.get(4).getCode());
		LOG.debug("Credit :{}", courses.get(4).getCredit());
		LOG.debug("++++++++++++++++++++++++++++++++++++++++++");

		return self();

	}

	@Pending
	public WhenIReviewExamVivaInfo i_review_viva_info() {

		return self();

	}

}
