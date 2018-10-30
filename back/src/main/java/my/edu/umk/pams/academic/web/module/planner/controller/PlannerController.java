package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.model.AdStudyMode;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.graduation.model.AdGraduation;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.web.module.graduation.controller.GraduationTransformer;
import my.edu.umk.pams.academic.web.module.graduation.vo.Graduation;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import my.edu.umk.pams.academic.web.module.term.vo.Assessment;
import my.edu.umk.pams.academic.web.module.term.vo.Offering;
import my.edu.umk.pams.academic.web.module.term.vo.Section;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author PAMS
 */
@Transactional
@RestController
@RequestMapping("/api/planner")
public class PlannerController {

	private static final Logger LOG = LoggerFactory.getLogger(PlannerController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private GraduationService graduationService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private PlannerTransformer plannerTransformer;
	
	@Autowired
	private GraduationTransformer graduationTransformer;
	
	@Autowired
	private SecurityService securityService;

	// ====================================================================================================
	// ACADEMIC SESSION
	// ====================================================================================================
	@RequestMapping(value = "/academicSessions", method = RequestMethod.GET)
	public ResponseEntity<List<AcademicSession>> findAcademicSessions() {
		List<AdAcademicSession> academicSessions = plannerService.findAcademicSessions(0, 1000);
		return new ResponseEntity<List<AcademicSession>>(plannerTransformer.toAcademicSessionVos(academicSessions),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/academicSessions/current", method = RequestMethod.GET)
	public ResponseEntity<AcademicSession> findCurrentAcademicSessions() {
		return new ResponseEntity<AcademicSession>(
				plannerTransformer.toAcademicSessionVo(plannerService.findCurrentAcademicSession()), HttpStatus.OK);
	}

	@RequestMapping(value = "/academicSessions/{code}", method = RequestMethod.GET)

	public ResponseEntity<AcademicSession> findAcademicSessionByCode(@PathVariable String code) {
		return new ResponseEntity<AcademicSession>(
				plannerTransformer.toAcademicSessionVo(plannerService.findAcademicSessionByCode(code)), HttpStatus.OK);
	}
	
	//find graduation by session
	@RequestMapping(value = "/academicSessions/{code}/graduations", method = RequestMethod.GET)
	public ResponseEntity<List<Graduation>> findGraduationsByAcademicSession(@PathVariable String code)
			throws UnsupportedEncodingException {
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
		List<AdGraduation> graduations = graduationService.findGraduations(academicSession);
		
		
		List<Graduation> graduationVos = graduationTransformer.toGraduationVos(graduations);
		
		return new ResponseEntity<List<Graduation>>(graduationVos, HttpStatus.OK);
	}

	@RequestMapping(value = "/academicSessions/{code}/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAcademicSession(@PathVariable String code, @RequestBody AcademicSession vo) {
		LOG.debug("SessionCode:{}", code);
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
		academicSession.setDescription(vo.getDescription());
		academicSession.setCurrent(vo.isCurrent());
		academicSession.setStartDate(vo.getstartDate());
		academicSession.setEndDate(vo.getendDate());
		academicSession.setEnrollStartDate(vo.getEnrollStartDate());
		academicSession.setEnrollEndDate(vo.getEnrollEndDate());
		academicSession.setAdmissionStartDate(vo.getAdmissionStartDate());
		academicSession.setAdmissionEndDate(vo.getAdmissionEndDate());
		academicSession.setGraduationStartDate(vo.getGraduationStartDate());
		academicSession.setGraduationEndDate(vo.getGraduationEndDate());	
		academicSession.setSemester(AdAcademicSemester.get(vo.getSemester().ordinal()));
		// academicSession.setYear(plannerService.findByCode(academicSession.getYear().getYear()));
		plannerService.updateAcademicSession(academicSession);
		return new ResponseEntity<String>(academicSession.getCode(), HttpStatus.OK);
	}

	@RequestMapping(value = "/academicSessions/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveAcademicSession(@PathVariable String code, @RequestBody AcademicSession vo) {

		if (isAcademicSessionCodeExists(code)) {

			System.out.println("Duplicate academic session:" + code);
	
		} else {

	
			
			if (isCurrent(true) == true) {
				AdAcademicSession academicSession1 = plannerService.findCurrentAcademicSession();
				System.out.println("Update previous session TRUE to FALSE first then save");
				System.out.println("Check state TRUE" + isCurrent(true));
				academicSession1.setCurrent(false);
				plannerService.updateAcademicSession(academicSession1);
				System.out.println("Updated session:" + academicSession1);

				AdAcademicSession academicSession = new AdAcademicSessionImpl();
				academicSession.setCode(vo.getCode());
				
				System.out.println("setDescription: SEMESTER " + vo.getSemester() + " " + vo.getYear().getDescription());
				
				academicSession.setDescription("SEMESTER " + vo.getSemester() + " " + vo.getYear().getDescription());
				academicSession.setCurrent(vo.isCurrent());
				academicSession.setStartDate(vo.getstartDate());
				academicSession.setEndDate(vo.getendDate());
				academicSession.setEnrollStartDate(vo.getEnrollStartDate());
				academicSession.setEnrollEndDate(vo.getEnrollEndDate());
				academicSession.setAdmissionStartDate(vo.getAdmissionStartDate());
				academicSession.setAdmissionEndDate(vo.getAdmissionEndDate());
				academicSession.setGraduationStartDate(vo.getGraduationStartDate());
				academicSession.setGraduationEndDate(vo.getGraduationEndDate());				
				academicSession.setSemester(AdAcademicSemester.get(vo.getSemester().ordinal()));
				
				academicSession.setYear(plannerService.findByCode(vo.getYear().getCode()));
				plannerService.saveAcademicSession(academicSession);

				System.out.println("Save session:" + code);
				//return new ResponseEntity<String>("Success", HttpStatus.OK);
			}else{
				AdAcademicSession academicSession = new AdAcademicSessionImpl();
				academicSession.setCode(vo.getCode());
				
				System.out.println("setDescription: SEMESTER " + vo.getSemester() + " " + vo.getYear().getDescription());
				
				academicSession.setDescription("SEMESTER " + vo.getSemester() + " " + vo.getYear().getDescription());
				academicSession.setCurrent(vo.isCurrent());
				academicSession.setStartDate(vo.getstartDate());
				academicSession.setEndDate(vo.getendDate());
				academicSession.setEnrollStartDate(vo.getEnrollStartDate());
				academicSession.setEnrollEndDate(vo.getEnrollEndDate());
				academicSession.setAdmissionStartDate(vo.getAdmissionStartDate());
				academicSession.setAdmissionEndDate(vo.getAdmissionEndDate());
				academicSession.setGraduationStartDate(vo.getGraduationStartDate());
				academicSession.setGraduationEndDate(vo.getGraduationEndDate());				
				academicSession.setSemester(AdAcademicSemester.get(vo.getSemester().ordinal()));
				academicSession.setYear(plannerService.findByCode(vo.getYear().getCode()));
				plannerService.saveAcademicSession(academicSession);

				System.out.println("Save session:" + code);
				
			}
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);

	}

	private boolean isCurrent(boolean b) {
		System.out.println(plannerService.isCurrent(b));
		return plannerService.isCurrent(b);
	}

	@RequestMapping(value = "/academicSessions/{code}/activate", method = RequestMethod.GET)
	public ResponseEntity<String> activateAcademicSession(@PathVariable String code) {
		LOG.debug("activate sesssion");
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
		academicSession.setCurrent(true);
		plannerService.updateAcademicSession(academicSession);
		return new ResponseEntity<String>(academicSession.getCode(), HttpStatus.OK);
	}

	@RequestMapping(value = "/academicSessions/{code}/deactivate", method = RequestMethod.GET)
	public ResponseEntity<String> deactivateAcademicSession(@PathVariable String code) {
		LOG.debug("deactivate sesssion");
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
		academicSession.setCurrent(false);
		plannerService.updateAcademicSession(academicSession);
		return new ResponseEntity<String>(academicSession.getCode(), HttpStatus.OK);
	}

	// ====================================================================================================
	// ACADEMIC YEAR
	// ====================================================================================================

	@RequestMapping(value = "/academicYears/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveAcademicYear(@PathVariable String code, @RequestBody AcademicYear vo) {
		if (isAcademicYearExists(vo.getCode())) {

			System.out.println("Duplicate academicYear:" + vo.getCode());
			return new ResponseEntity<String>("Duplicate", HttpStatus.OK);
		} else {
			AdAcademicYear year = new AdAcademicYearImpl();
			year.setCode(vo.getCode());
			year.setDescription(vo.getDescription());
			year.setYear(vo.getYear());
			plannerService.saveAcademicYear(year);

			System.out.println("Save academicYear:" + vo.getCode());
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
	}

	// update academicYear
	@RequestMapping(value = "/academicYears/{code}/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAcademicYear(@PathVariable String code, @RequestBody AcademicYear vo) {
		System.out.println("Update academicYear:" + vo.getCode());
		
		AdAcademicYear academicYear = plannerService.findAcademicYearByCode(code);	
		academicYear.setDescription(vo.getDescription());
		academicYear.setYear(vo.getYear());
		plannerService.updateAcademicYear(academicYear);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	//remove academicYear
	 @RequestMapping(value = "/academicYears/{code}", method = RequestMethod.DELETE)
	  public ResponseEntity<String> removeAcademicYear(@PathVariable String code) {

	          AdAcademicYear academicYear = plannerService.findAcademicYearByCode(code);
	          plannerService.removeAcademicYear(academicYear);
	          
	          System.out.println("removeAcademicYear:" + academicYear);
	          return new ResponseEntity<String>("Success", HttpStatus.OK);
	          }
	
	
	// ====================================================================================================
	// PROGRAM LEVEL
	// ====================================================================================================

	@RequestMapping(value = "/programLevels", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramLevel>> findProgramLevels() {
		List<AdProgramLevel> programLevels = plannerService.findProgramLevels(0, 1000);
		return new ResponseEntity<List<ProgramLevel>>(plannerTransformer.toProgramLevelVos(programLevels),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/programLevels/{code}", method = RequestMethod.GET)
	public ResponseEntity<ProgramLevel> findProgramLevelByCode(@PathVariable String code) {
		return new ResponseEntity<ProgramLevel>(
				plannerTransformer.toProgramLevelVo(plannerService.findProgramLevelByCode(code)), HttpStatus.OK);
	}

	@RequestMapping(value = "/programLevels/{code}/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateProgramLevel(@PathVariable String code, @RequestBody ProgramLevel vo) {
		LOG.debug("LevelCode:{}", code);
		AdProgramLevel programLevel = plannerService.findProgramLevelByCode(code);
		programLevel.setDescription(vo.getDescription());
		plannerService.updateProgramLevel(programLevel);
		return new ResponseEntity<String>(programLevel.getCode(), HttpStatus.OK);
	}

	@RequestMapping(value = "/programLevels/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveProgramLevel(@PathVariable String code, @RequestBody ProgramLevel vo) {
		AdProgramLevel programLevel = new AdProgramLevelImpl();
		programLevel.setCode(vo.getCode());
		programLevel.setDescription(vo.getDescription());
		plannerService.saveProgramLevel(programLevel);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// FACULTY
	// ====================================================================================================

	@RequestMapping(value = "/faculties/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveFaculty(@PathVariable String code, @RequestBody Faculty vo) {
		AdFaculty faculty = new AdFacultyImpl();
		faculty.setCode(vo.getCode());
		faculty.setDescription(vo.getDescription());
		faculty.setName(vo.getName());
		faculty.setPrefix(vo.getPrefix());
		faculty.setStatus(AdFacultyStatus.get(vo.getStatus().ordinal()));
		plannerService.saveFaculty(faculty);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateFaculty(@PathVariable String code, @RequestBody Faculty vo) {
		LOG.debug("faculty code:{}", code);
		AdFaculty faculty = plannerService.findFacultyByCode(code);
		faculty.setDescription(vo.getDescription());
		faculty.setName(vo.getName());
		faculty.setPrefix(vo.getPrefix());
		faculty.setStatus(AdFacultyStatus.get(vo.getStatus().ordinal()));
		plannerService.updateFaculty(faculty);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}/activate", method = RequestMethod.GET)
	public ResponseEntity<String> activateFacultiy(@PathVariable String code) {
		LOG.debug("activate program");
		AdFaculty faculty = plannerService.findFacultyByCode(code);
		faculty.setStatus(AdFacultyStatus.ACTIVE);
		plannerService.updateFaculty(faculty);
		return new ResponseEntity<String>(faculty.getCode(), HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}/deactivate", method = RequestMethod.GET)
	public ResponseEntity<String> deactivateFaculty(@PathVariable String code) {
		LOG.debug("deactivate program");
		AdFaculty faculty = plannerService.findFacultyByCode(code);
		faculty.setStatus(AdFacultyStatus.INACTIVE);
		plannerService.updateFaculty(faculty);
		return new ResponseEntity<String>(faculty.getCode(), HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties", method = RequestMethod.GET)
	public ResponseEntity<List<Faculty>> findFaculties() {
		List<AdFaculty> faculties = plannerService.findFaculties(0, 1000);
		return new ResponseEntity<List<Faculty>>(plannerTransformer.toFacultyVos(faculties), HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}", method = RequestMethod.GET)
	public ResponseEntity<Faculty> findFacultyByCode(@PathVariable String code) throws UnsupportedEncodingException {
		return new ResponseEntity<Faculty>(plannerTransformer.toFacultyVo(plannerService.findFacultyByCode(code)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}/programs", method = RequestMethod.GET)
	public ResponseEntity<List<Program>> findProgramsByFaculty(@PathVariable String code)
			throws UnsupportedEncodingException {
		AdFaculty faculty = plannerService.findFacultyByCode(code);
		return new ResponseEntity<List<Program>>(plannerTransformer.toProgramVos(plannerService.findPrograms(faculty)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/faculties/{code}/courses", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> findCoursesByFaculty(@PathVariable String code)
			throws UnsupportedEncodingException {
		AdFaculty faculty = plannerService.findFacultyByCode(code);
		return new ResponseEntity<List<Course>>(plannerTransformer.toCourseVos(plannerService.findCourses(faculty)),
				HttpStatus.OK);
	}

	// ====================================================================================================
	// PROGRAM
	// ====================================================================================================

	@RequestMapping(value = "/programs", method = RequestMethod.GET)
	public ResponseEntity<List<Program>> findPrograms() {
		
		AdUser user = securityService.getCurrentUser();
		AdStaff staff = null;
		List<AdProgram> programs = null;
		if(user.getActor() instanceof AdStaff){
			staff = (AdStaff) user.getActor();
			programs = plannerService.findPrograms(staff.getFaculty().getCenter());
			
		}else{
			LOG.info("User Login Have No Faculty");
			programs = plannerService.findPrograms(0, Integer.MAX_VALUE);
		}
		
		return new ResponseEntity<List<Program>>(plannerTransformer.toProgramVos(programs), HttpStatus.OK);
	}

	@RequestMapping(value = "/programs/{code}", method = RequestMethod.GET)
	public ResponseEntity<Program> findProgramByCode(@PathVariable String code) {
		Program program = plannerTransformer.toProgramVo(plannerService.findProgramByCode(code));
		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}

	@RequestMapping(value = "/programs/{code}/cohorts", method = RequestMethod.GET)
	public ResponseEntity<List<Cohort>> findCohortsByProgram(@PathVariable String code) {
		AdProgram program = plannerService.findProgramByCode(code);
		return new ResponseEntity<List<Cohort>>(
				plannerTransformer.toCohortVos(plannerService.findCohorts(program, 0, 1000)), HttpStatus.OK);
	}

	@RequestMapping(value = "/programs/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveProgram(@PathVariable String code, @RequestBody Program vo) {
		if (isProgramExists(code, plannerService.findFacultyById(vo.getFaculty().getId()))) {
			// throw new IllegalArgumentException("Data program already exists!
			// Please insert new data");

			System.out.println("Faculty1" + plannerService.findFacultyById(vo.getFaculty().getId()));
			System.out.println("Program Code1" + code);
			System.out.println("Program Code2" + vo.getCode());
			System.out.println("Duplicate program:" + code);

			return new ResponseEntity<String>("Duplicate", HttpStatus.OK);
		} else {

			AdProgram program = new AdProgramImpl();
			program.setCode(vo.getCode());
			program.setTitleMs(vo.getTitleMs());
			program.setTitleEn(vo.getTitleEn());
			program.setStatus(AdProgramStatus.get(vo.getStatus().ordinal()));
			program.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
			program.setLevel(plannerService.findProgramLevelById(vo.getLevel().getId()));
			plannerService.saveProgram(program);

			System.out.println("Save new program:" + code);
			System.out.println(program.getCode());
			System.out.println(program.getTitleEn());
			return new ResponseEntity<String>("Success", HttpStatus.OK);

		}

	}

	// isProgramExists
	private boolean isProgramExists(String code, AdFaculty faculty) {
		return plannerService.isProgramExists(code, faculty);
	}

	// isCourseExists
	private boolean isCourseExists(String code, AdFaculty faculty) {
		System.out.println(plannerService.isCourseExists(code, faculty));
		return plannerService.isCourseExists(code, faculty);
	}

	// isAcademicSessionCodeExists
	private boolean isAcademicSessionCodeExists(String code) {
		System.out.println(plannerService.isAcademicSessionCodeExists(code));
		return plannerService.isAcademicSessionCodeExists(code);
	}

	// isAcademicYearExists
	private boolean isAcademicYearExists(String code) {
		System.out.println(plannerService.isAcademicYearExists(code));
		return plannerService.isAcademicYearExists(code);
	}

	// isCohortExists
	private boolean isCohortExists(String code) {
		System.out.println(plannerService.isCohortExists(code));
		return plannerService.isCohortExists(code);
	}

	@RequestMapping(value = "/programs/{code}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateProgram(@PathVariable String code, @RequestBody Program vo) {
		AdProgram program = plannerService.findProgramByCode(code);
		program.setCode(vo.getCode());
		program.setTitleMs(vo.getTitleMs());
		program.setTitleEn(vo.getTitleEn());
		program.setStatus(AdProgramStatus.get(vo.getStatus().ordinal()));
		plannerService.updateProgram(program);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/programs/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeProgram(@PathVariable String code) {
		AdProgram program = plannerService.findProgramByCode(code);
		plannerService.removeProgram(program);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/programs/{code}/activate", method = RequestMethod.GET)
	public ResponseEntity<String> activateProgram(@PathVariable String code) {
		LOG.debug("activate program");
		AdProgram program = plannerService.findProgramByCode(code);
		program.setStatus(AdProgramStatus.ACTIVE);
		plannerService.updateProgram(program);
		return new ResponseEntity<String>(program.getCode(), HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/programs/{code}/deactivate", method = RequestMethod.GET)
	public ResponseEntity<String> deactivateProgram(@PathVariable String code) {
		LOG.debug("deactivate program");
		AdProgram program = plannerService.findProgramByCode(code);
		program.setStatus(AdProgramStatus.INACTIVE);
		plannerService.updateProgram(program);
		return new ResponseEntity<String>(program.getCode(), HttpStatus.OK);
	}

	// ====================================================================================================
	// Course
	// ====================================================================================================

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> findCourses() {
	
		AdUser user = securityService.getCurrentUser();
		AdStaff staff = null;
		List<AdCourse> courses = null;
		if(user.getActor() instanceof AdStaff){
			staff = (AdStaff) user.getActor();
			
			courses = plannerService.findCourses(staff.getFaculty().getCenter());
			
		}else{
			LOG.info("User Login Have No Faculty");
			courses = plannerService.findCourses(0, Integer.MAX_VALUE);
		}
	
		
		return new ResponseEntity<List<Course>>(plannerTransformer.toCourseVos(courses),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/courses/page/{pageNo}", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> findCourses(@PathVariable Integer pageNo) {
		throw new UnsupportedOperationException();
	}

	@RequestMapping(value = "/courses/{code}", method = RequestMethod.GET)
	public ResponseEntity<Course> findCourseByCode(@PathVariable String code) throws UnsupportedEncodingException {
		return new ResponseEntity<Course>(plannerTransformer.toCourseVo(plannerService.findCourseByCode(code)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/courses/create", method = RequestMethod.POST)
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		throw new UnsupportedOperationException();
	}

	/*
	 * @RequestMapping(value = "/courses/{code}/add", method =
	 * RequestMethod.POST) public ResponseEntity<String> addCourse(@PathVariable
	 * String code, @RequestBody Course vo) { dummyLogin();
	 * 
	 * if (isCourseExists(code,
	 * plannerService.findFacultyById(vo.getFaculty().getId()))){ //throw new
	 * IllegalArgumentException("Data program already exists! Please insert new data"
	 * );
	 * 
	 * System.out.println("Faculty1" +
	 * plannerService.findFacultyById(vo.getFaculty().getId()));
	 * System.out.println("Course Code1" + code );
	 * System.out.println("Course Code2" + vo.getCode() );
	 * System.out.println("Duplicate course:" + code );
	 * 
	 * return new ResponseEntity<String>("Duplicate", HttpStatus.OK); } else {
	 * 
	 * AdCourse course = new AdCourseImpl(); course.setCode(vo.getCode());
	 * course.setTitleMs(vo.getTitleMs()); course.setTitleEn(vo.getTitleEn());
	 * course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
	 * course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId())
	 * ); course.setClassification(AdAcademicClassification.get(vo.
	 * getClassification().ordinal())); plannerService.addCourse(course);
	 * 
	 * System.out.println("Add course success:" + code );
	 * System.out.println(course.getCode() );
	 * System.out.println(course.getTitleEn());
	 * System.out.println(course.getClassification());
	 * 
	 * return new ResponseEntity<String>("Success", HttpStatus.OK); } }
	 */

	@RequestMapping(value = "/courses/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveCourse(@PathVariable String code, @RequestBody Course vo) {
		if (isCourseExists(code, plannerService.findFacultyById(vo.getFaculty().getId()))) {
			// throw new IllegalArgumentException("Data program already exists!
			// Please insert new data");

			System.out.println("Faculty1" + plannerService.findFacultyById(vo.getFaculty().getId()));
			System.out.println("Course Code1" + code);
			System.out.println("Course Code2" + vo.getCode());
			System.out.println("Duplicate course:" + code);

			return new ResponseEntity<String>("Duplicate", HttpStatus.OK);
		} else {

			AdCourse course = new AdCourseImpl();
			course.setCode(vo.getCode());
			course.setTitleMs(vo.getTitleMs());
			course.setTitleEn(vo.getTitleEn());
			course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
			course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
			course.setCredit(vo.getCredit());
			course.setClassification(AdAcademicClassification.get(vo.getClassification().ordinal()));
			plannerService.saveCourse(course);

			System.out.println("Add course success:" + code);
			System.out.println(course.getCode());
			System.out.println(course.getTitleEn());
			System.out.println(course.getClassification());

			return new ResponseEntity<String>("Success", HttpStatus.OK);

		}

	}

	@RequestMapping(value = "/courses/{code}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCourse(@PathVariable String code, @RequestBody Course vo) {
		AdCourse course = plannerService.findCourseByCode(code);
		// course.setClassification(AdAcademicClassification.get(vo.getClassification().ordinal()));
		course.setCode(vo.getCode());
		course.setCredit(vo.getCredit());
		course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
		course.setTitleEn(vo.getTitleEn());
		course.setTitleMs(vo.getTitleMs());
		// course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
		plannerService.updateCourse(course);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/courses/{code}/activate", method = RequestMethod.GET)
	public ResponseEntity<String> activateCourse(@PathVariable String code) {
		LOG.debug("activate course");
		AdCourse course = plannerService.findCourseByCode(code);
		course.setStatus(AdCourseStatus.ACTIVE);
		plannerService.updateCourse(course);
		return new ResponseEntity<String>(course.getCode(), HttpStatus.OK);

	}

	@RequestMapping(value = "/courses/{code}/deactivate", method = RequestMethod.GET)
	public ResponseEntity<String> deactivateCourse(@PathVariable String code) {
		LOG.debug("deactivate course");
		AdCourse course = plannerService.findCourseByCode(code);
		course.setStatus(AdCourseStatus.INACTIVE);
		plannerService.updateCourse(course);
		return new ResponseEntity<String>(course.getCode(), HttpStatus.OK);

	}

	// ====================================================================================================
	// ACADEMIC YEAR
	// ====================================================================================================

	@RequestMapping(value = "/academicYears", method = RequestMethod.GET)
	public ResponseEntity<List<AcademicYear>> findAcademicYears() {
		return new ResponseEntity<List<AcademicYear>>(
				plannerTransformer.toAcademicYearVos(plannerService.findAcademicYears(0, 1000)), HttpStatus.OK);
	}

	// ====================================================================================================
	// CURRICULUM
	// ====================================================================================================

	@RequestMapping(value = "/curriculums", method = RequestMethod.GET)
	public ResponseEntity<List<Curriculum>> findCurriculums() {
		return new ResponseEntity<List<Curriculum>>(
				plannerTransformer.toCurriculumVos(plannerService.findCurriculums(0, 1000)), HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}", method = RequestMethod.GET)
	public ResponseEntity<Curriculum> findCurriculumByCode(@PathVariable String code) {
		Curriculum curriculum = plannerTransformer.toCurriculumVo(plannerService.findCurriculumByCode(code));
		return new ResponseEntity<Curriculum>(curriculum, HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveCurriculum(@PathVariable String code, @RequestBody Curriculum vo) {
		AdCurriculum curriculum = new AdCurriculumImpl();
		curriculum.setCode(vo.getCode());
		curriculum.setCoreCredit(vo.getCoreCredit());
		curriculum.setCurriculumCredit(vo.getCurriculumCredit());
		curriculum.setElectiveCredit(vo.getElectiveCredit());
		curriculum.setGeneralCredit(vo.getGeneralCredit());
		curriculum.setLanguageCredit(vo.getLanguageCredit());
		curriculum.setOthersCredit(vo.getOtherCredit());
		curriculum.setRequiredCredit(vo.getRequiredCredit());
		curriculum.setTotalCredit(vo.getTotalCredit());
		curriculum.setPeriod(vo.getPeriod());
		curriculum.setMaxPeriod(vo.getMaxPeriod());
		curriculum.setOrdinal(vo.getOrdinal());
		curriculum.setProgram(plannerService.findProgramByCode(vo.getProgram().getCode()));
		// curriculum.setSubjects(plannerService.findSubjects(curriculum));
		plannerService.saveCurriculum(curriculum);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	//update curriculum
	@RequestMapping(value = "/curriculums/{code}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCurriculum(@PathVariable String code, @RequestBody Curriculum vo) {
		
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		curriculum.setCoreCredit(vo.getCoreCredit());
		curriculum.setElectiveCredit(vo.getElectiveCredit());
		curriculum.setGeneralCredit(vo.getGeneralCredit());
		curriculum.setMaxPeriod(vo.getMaxPeriod());
		curriculum.setOrdinal(vo.getOrdinal());
		curriculum.setPeriod(vo.getPeriod());
		curriculum.setRequiredCredit(vo.getRequiredCredit());
		curriculum.setTotalCredit(vo.getTotalCredit());
		curriculum.setProgram(plannerService.findProgramByCode(vo.getProgram().getCode()));
		plannerService.updateCurriculum(curriculum);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/subjects", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjectsByCurriculum(@PathVariable String code)
			throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		List<AdSubject> subjects = plannerService.findSubjects(curriculum);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/bundleSubjects", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findBundleSubjectsByCurriculum(@PathVariable String code)
			throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		List<AdSubject> subjects = plannerService.findSubjects(curriculum);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);

	}

	@RequestMapping(value = "/curriculums/bundleSubject/{id}/subjects", method = RequestMethod.GET)
	public ResponseEntity<List<BundleSubjectPart>> findBundleSubjectsPart(@PathVariable Long id)
			throws UnsupportedEncodingException {

		AdBundleSubject bundle = plannerService.findBundleSubjectById(id);
		List<AdBundleSubjectPart> subjectPart = plannerService.findBundleSubjectPartByBundleSubject(bundle);
		return new ResponseEntity<List<BundleSubjectPart>>(plannerTransformer.toBundleSubjectPartVos(subjectPart),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/curriculums/{code}/subjects/subjectType/{subjectType}", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjectsByCurriculumAndSubjectType(@PathVariable String code,
			@PathVariable String subjectType) throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdSubjectType subjType = AdSubjectType.valueOf(subjectType);
		List<AdSubject> subjects = plannerService.findSubjectsBySubjectType(curriculum, subjType);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/singleSubjects", method = RequestMethod.POST)
	public ResponseEntity<String> addSingleSubject(@PathVariable String code, @RequestBody SingleSubject vo) {
		LOG.info("Adding single subject");
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdCourse course = plannerService.findCourseByCode(vo.getCourse().getCode());
		AdSingleSubject subject = new AdSingleSubjectImpl();
		subject.setCourse(course);
		subject.setOrdinal(vo.getOrdinal());
		subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		plannerService.addSubject(curriculum, subject);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/bundleSubjects", method = RequestMethod.POST)
	public ResponseEntity<String> addBundleSubject(@PathVariable String code, @RequestBody BundleSubject vo) {
		LOG.debug("Adding bundle subject");
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
		// bundleSubject.setSubjectType(AdSubjectType.ELECTIVE);
		bundleSubject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		bundleSubject.setOrdinal(vo.getOrdinal());
		bundleSubject.setSubjectElectiveStatus(AdSubjectElectiveStatus.get(vo.getSubjectElectiveStatus().ordinal()));
		plannerService.addSubject(curriculum, bundleSubject);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{id}/subjectParts", method = RequestMethod.POST)
	public ResponseEntity<String> addSubjectPart(@PathVariable Long id, @RequestBody BundleSubjectPart vo) {
		LOG.info("Adding subject part");
		AdCourse course = plannerService.findCourseByCode(vo.getCourse().getCode());
		AdBundleSubject bundleSubject = plannerService.findBundleSubjectById(id);
		AdBundleSubjectPart part = new AdBundleSubjectPartImpl();
		part.setCourse(course);
		part.setBundle(bundleSubject);
		plannerService.addSubjectPart(bundleSubject, part);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/subject", method = RequestMethod.POST)
	public ResponseEntity<String> addSubject(@PathVariable Long id, @RequestBody Subject vo) {
		LOG.info("Haiii");
		AdCurriculum curriculum = plannerService.findCurriculumById(id);
		AdSubject subject = new AdSubjectImpl();
		subject.setOrdinal(vo.getOrdinal());
		subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		plannerService.addSubject(curriculum, subject);

		if (vo.getSubjectType().ordinal() == 1) {
			// bundle subject here
			AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
			bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
			bundleSubject.setOrdinal(1);
			plannerService.addSubject(curriculum, bundleSubject);
		} else {

			// proced to single subject
			AdSingleSubject subject1 = new AdSingleSubjectImpl();
			subject1.setCourse(plannerService.findCourseByCode(null));
			subject.setOrdinal(vo.getOrdinal());
			subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
			plannerService.addSubject(curriculum, subject);

		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// COHORT
	// ====================================================================================================

	@RequestMapping(value = "/cohorts", method = RequestMethod.GET)
	public ResponseEntity<List<Cohort>> findCohorts() {
		
		AdUser user = securityService.getCurrentUser();
		AdStaff staff = null;
		List<AdCohort> cohorts = null;
		if(user.getActor() instanceof AdStaff){
			staff = (AdStaff) user.getActor();
			cohorts = plannerService.findCohorts(staff.getFaculty().getCenter());
			
		}else{
			LOG.info("User Login Have No Faculty");
			cohorts = plannerService.findCohorts("%", 0, Integer.MAX_VALUE);
		}
		
		return new ResponseEntity<List<Cohort>>(
				plannerTransformer.toCohortVos(cohorts), HttpStatus.OK);
	}

	@RequestMapping(value = "/cohorts/{code}", method = RequestMethod.GET)
	public ResponseEntity<Cohort> findCohortByCode(@PathVariable String code) throws UnsupportedEncodingException {
		return new ResponseEntity<Cohort>(plannerTransformer.toCohortVo(plannerService.findCohortByCode(code)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/cohorts", method = RequestMethod.POST)
	public ResponseEntity<String> saveCohort(@RequestBody Cohort vo) {

		if (isCohortExists(vo.getCode())) {

			System.out.println("Duplicate cohort:" + vo.getCode());
			return new ResponseEntity<String>("Duplicate", HttpStatus.OK);
		} else {

			// save data normally
			AdProgram program = plannerService.findProgramById(vo.getProgram().getId());
			AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
			//AdCurriculum curriculum = plannerService.findCurriculumByCode(vo.getCurriculum().getCode());
			AdCohort cohort = new AdCohortImpl();
			cohort.setCode(program.getCode() + "-" + academicSession.getCode());
			cohort.setDescription("COHORT " + program.getCode());
			cohort.setProgram(program);
			cohort.setSession(academicSession);
			cohort.setCurriculum(plannerService.findCurriculumByCode(vo.getCurriculum().getCode()));
			plannerService.saveCohort(cohort);

			System.out.println("Save cohort:" + vo.getCode());
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/cohorts/{code}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCohort(@PathVariable String code, @RequestBody Cohort vo) {

		AdCohort cohort = plannerService.findCohortByCode(code);
		cohort.setCode(vo.getCode());
		cohort.setDescription(vo.getDescription());
		cohort.setCurriculum(plannerService.findCurriculumByCode(vo.getCurriculum().getCode()));
		plannerService.updateCohort(cohort);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// ====================================================================================================
	// SUBJECT
	// ====================================================================================================

	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjects(@PathVariable String code) throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		List<AdSubject> subjects = plannerService.findSubjects(curriculum);
		List<Subject> subjectVos = plannerTransformer.toSubjectVos(subjects);
		return new ResponseEntity<List<Subject>>(subjectVos, HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/subjects/subjectTypeCore/{subjectType}", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjectsByCurriculumAndSubjectTypeCore(@PathVariable String code,
			@PathVariable String subjectType) throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdSubjectType subjType = AdSubjectType.valueOf(subjectType);
		System.out.println("subjType" + subjType);
		List<AdSubject> subjects = plannerService.findSubjectsByCurriculumAndSubjectTypeCore(curriculum, subjType);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
	}
	
	//core elective
	@RequestMapping(value = "/curriculums/{code}/subjects/subjectTypeCoreElective/{subjectType}", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjectsByCurriculumAndSubjectTypeCoreElective(@PathVariable String code,
			@PathVariable String subjectType) throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdSubjectType subjType = AdSubjectType.valueOf(subjectType);
		System.out.println("subjType" + subjType);
		List<AdSubject> subjects = plannerService.findSubjectsByCurriculumAndSubjectTypeCoreElective(curriculum, subjType);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
	}

	@RequestMapping(value = "/curriculums/{code}/subjects/subjectTypeElective/{subjectType}", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> findSubjectsByCurriculumAndSubjectTypeElective(@PathVariable String code,
			@PathVariable String subjectType) throws UnsupportedEncodingException {
		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdSubjectType subjType = AdSubjectType.valueOf(subjectType);
		System.out.println("subjType" + subjType);
		List<AdSubject> subjects = plannerService.findSubjectsByCurriculumAndSubjectTypeElective(curriculum, subjType);
		return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
	}

	// delete subject by curriculum
	@RequestMapping(value = "/curriculums/{code}/subjects/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSubject(@PathVariable String code, @PathVariable Long id) {

		AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
		AdSubject subject = plannerService.findSubjectById(id);
		plannerService.deleteSubject(curriculum, subject);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/curriculums/{id}/bundleSubjectParts", method = RequestMethod.POST)
	public ResponseEntity<String> deleteSubjectPart(@PathVariable Long id,@RequestBody BundleSubjectPart vo) {
		
		AdBundleSubject bundleSubject = plannerService.findBundleSubjectById(id);
		AdBundleSubjectPart part = plannerService.findBundleSubjectPartById(vo.getId());
		plannerService.deleteSubjectPart(bundleSubject, part);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/subjects/{id}", method = RequestMethod.GET)
	public ResponseEntity<Subject> findSubjectById(@PathVariable Long id) {
		AdSubject subject = plannerService.findSubjectById(id);
		return new ResponseEntity<Subject>(plannerTransformer.toSubjectVo(subject), HttpStatus.OK);
	}

	@RequestMapping(value = "/subjects/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody Subject vo) {

		AdCurriculum curriculum = plannerService.findCurriculumById(id);
		AdSubject subject = plannerService.findSubjectById(id);
		subject.setOrdinal(vo.getOrdinal());
		subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		plannerService.updateSubject(curriculum, subject);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/subjects/{id}/activate", method = RequestMethod.GET)
	public ResponseEntity<String> activateSubject(@PathVariable Long id, @RequestBody Subject vo) {
		LOG.debug("activate subjects");
		AdCurriculum curriculum = plannerService.findCurriculumById(id);
		AdSubject subject = plannerService.findSubjectById(id);
		subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		plannerService.updateSubject(curriculum, subject);
		return new ResponseEntity<String>("success", HttpStatus.OK);

	}

	@RequestMapping(value = "/subjects/{id}/deactivate", method = RequestMethod.GET)
	public ResponseEntity<String> deactivateSubject(@PathVariable Long id, @RequestBody Subject vo) {
		LOG.debug("deactivate subjects");
		AdCurriculum curriculum = plannerService.findCurriculumById(id);
		AdSubject subject = plannerService.findSubjectById(id);
		subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
		plannerService.updateSubject(curriculum, subject);
		return new ResponseEntity<String>("success", HttpStatus.OK);

	}
	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

}
