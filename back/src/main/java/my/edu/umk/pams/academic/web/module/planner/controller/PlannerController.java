package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import my.edu.umk.pams.academic.web.module.planner.vo.Subject;

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
    private IdentityService identityService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private PlannerTransformer plannerTransformer;


    // ====================================================================================================
    // ACADEMIC SESSION
    // ====================================================================================================
    @RequestMapping(value = "/academicSessions", method = RequestMethod.GET)
    public ResponseEntity<List<AcademicSession>> findAcademicSessions() {
        List<AdAcademicSession> academicSessions = plannerService.findAcademicSessions(0, 100);
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

    @RequestMapping(value = "/academicSessions/{code}/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAcademicSession(@PathVariable String code, @RequestBody AcademicSession vo) {
        dummyLogin();
        LOG.debug("SessionCode:{}", code);
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
        academicSession.setDescription(vo.getDescription());
        academicSession.setCurrent(vo.isCurrent());
        academicSession.setStartDate(vo.getstartDate());
        academicSession.setEndDate(vo.getendDate());
        academicSession.setSemester(AdAcademicSemester.get(vo.getSemester().ordinal()));
        // academicSession.setYear(plannerService.findByCode(academicSession.getYear().getYear()));
        plannerService.updateAcademicSession(academicSession);
        return new ResponseEntity<String>(academicSession.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/academicSessions/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveAcademicSession(@PathVariable String code, @RequestBody AcademicSession vo) {
        dummyLogin();
        AdAcademicSession academicSession = new AdAcademicSessionImpl();
        academicSession.setCode(vo.getCode());
        academicSession.setDescription(vo.getDescription());
        academicSession.setCurrent(vo.isCurrent());
        academicSession.setStartDate(vo.getstartDate());
        academicSession.setEndDate(vo.getendDate());
        academicSession.setSemester(AdAcademicSemester.get(vo.getSemester().ordinal()));
        // academicSession.setYear(plannerTransformer.toAcademicYearVo(academicYear.getYear()));
        academicSession.setYear(plannerService.findByCode(vo.getYear().getCode()));
        plannerService.saveAcademicSession(academicSession);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/academicSessions/{code}/activate", method = RequestMethod.GET)
    public ResponseEntity<String> activateAcademicSession(@PathVariable String code) {
        dummyLogin();
        LOG.debug("activate sesssion");
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(code);
        academicSession.setCurrent(true);
        plannerService.updateAcademicSession(academicSession);
        return new ResponseEntity<String>(academicSession.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/academicSessions/{code}/deactivate", method = RequestMethod.GET)
    public ResponseEntity<String> deactivateAcademicSession(@PathVariable String code) {
        dummyLogin();
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
        dummyLogin();
        AdAcademicYear year = new AdAcademicYearImpl();
        year.setCode(vo.getCode());
        year.setDescription(vo.getDescription());
        year.setYear(vo.getYear());
        plannerService.saveAcademicYear(year);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ====================================================================================================
    // PROGRAM LEVEL
    // ====================================================================================================

    @RequestMapping(value = "/programLevels", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramLevel>> findProgramLevels() {
        List<AdProgramLevel> programLevels = plannerService.findProgramLevels(0, 100);
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
        dummyLogin();
        LOG.debug("LevelCode:{}", code);
        AdProgramLevel programLevel = plannerService.findProgramLevelByCode(code);
        programLevel.setDescription(vo.getDescription());
        plannerService.updateProgramLevel(programLevel);
        return new ResponseEntity<String>(programLevel.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/programLevels/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveProgramLevel(@PathVariable String code, @RequestBody ProgramLevel vo) {
        dummyLogin();
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
        dummyLogin();
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
        dummyLogin();
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
        dummyLogin();
        LOG.debug("activate program");
        AdFaculty faculty = plannerService.findFacultyByCode(code);
        faculty.setStatus(AdFacultyStatus.ACTIVE);
        plannerService.updateFaculty(faculty);
        return new ResponseEntity<String>(faculty.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculties/{code}/deactivate", method = RequestMethod.GET)
    public ResponseEntity<String> deactivateFaculty(@PathVariable String code) {
        dummyLogin();
        LOG.debug("deactivate program");
        AdFaculty faculty = plannerService.findFacultyByCode(code);
        faculty.setStatus(AdFacultyStatus.INACTIVE);
        plannerService.updateFaculty(faculty);
        return new ResponseEntity<String>(faculty.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public ResponseEntity<List<Faculty>> findFaculties() {
        List<AdFaculty> faculties = plannerService.findFaculties(0, 100);
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
        List<AdProgram> programs = plannerService.findPrograms(0, 100);
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
                plannerTransformer.toCohortVos(plannerService.findCohorts(program, 0, 100)), HttpStatus.OK);
    }

    @RequestMapping(value = "/programs/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveProgram(@PathVariable String code, @RequestBody Program vo) {
        dummyLogin();
        AdProgram program = new AdProgramImpl();
        program.setCode(vo.getCode());
        program.setTitleMs(vo.getTitleMs());
        program.setTitleEn(vo.getTitleEn());
        program.setStatus(AdProgramStatus.get(vo.getStatus().ordinal()));
        program.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
        program.setLevel(plannerService.findProgramLevelById(vo.getLevel().getId()));
        plannerService.saveProgram(program);
        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @RequestMapping(value = "/programs/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProgram(@PathVariable String code, @RequestBody Program vo) {
        dummyLogin();
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
        dummyLogin();
        AdProgram program = plannerService.findProgramByCode(code);
        plannerService.removeProgram(program);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/programs/{code}/activate", method = RequestMethod.GET)
    public ResponseEntity<String> activateProgram(@PathVariable String code) {
        dummyLogin();
        LOG.debug("activate program");
        AdProgram program = plannerService.findProgramByCode(code);
        program.setStatus(AdProgramStatus.ACTIVATED);
        plannerService.updateProgram(program);
        return new ResponseEntity<String>(program.getCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/programs/{code}/deactivate", method = RequestMethod.GET)
    public ResponseEntity<String> deactivateProgram(@PathVariable String code) {
        dummyLogin();
        LOG.debug("deactivate program");
        AdProgram program = plannerService.findProgramByCode(code);
        program.setStatus(AdProgramStatus.INACTIVATED);
        plannerService.updateProgram(program);
        return new ResponseEntity<String>(program.getCode(), HttpStatus.OK);
    }

    // ====================================================================================================
    // Course
    // ====================================================================================================

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> findCourses() {
        return new ResponseEntity<List<Course>>(plannerTransformer.toCourseVos(plannerService.findCourses(0, 100)),
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

    @RequestMapping(value = "/courses/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveCourse(@PathVariable String code, @RequestBody Course vo) {
        dummyLogin();
        AdCourse course = new AdCourseImpl();
        course.setCode(vo.getCode());
        course.setTitleMs(vo.getTitleMs());
        course.setTitleEn(vo.getTitleEn());
        course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
        course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
        course.setClassification(AdAcademicClassification.get(vo.getClassification().ordinal()));
        plannerService.addCourse(new AdFacultyImpl(), course);
        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @RequestMapping(value = "/courses/{code}/add", method = RequestMethod.POST)
    public ResponseEntity<String> addCourse(@PathVariable String code, @RequestBody Course vo) {
        dummyLogin();
        AdCourse course = new AdCourseImpl();
        course.setCode(vo.getCode());
        course.setTitleMs(vo.getTitleMs());
        course.setTitleEn(vo.getTitleEn());
        course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
        course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
        course.setClassification(AdAcademicClassification.get(vo.getClassification().ordinal()));
        plannerService.addCourse(new AdFacultyImpl(), course);
        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @RequestMapping(value = "/courses/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCourse(@PathVariable String code, @RequestBody Course vo) {
        dummyLogin();
        AdCourse course = plannerService.findCourseByCode(code);
        //course.setClassification(AdAcademicClassification.get(vo.getClassification().ordinal()));
        course.setCode(vo.getCode());
        //course.setCredit(vo.getCredit());
        course.setStatus(AdCourseStatus.get(vo.getStatus().ordinal()));
        course.setTitleEn(vo.getTitleEn());
        course.setTitleMs(vo.getTitleMs());
        //course.setFaculty(plannerService.findFacultyById(vo.getFaculty().getId()));
        plannerService.updateCourse(course);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{code}/activate", method = RequestMethod.GET)
    public ResponseEntity<String> activateCourse(@PathVariable String code) {
        dummyLogin();
        LOG.debug("activate course");
        AdCourse course = plannerService.findCourseByCode(code);
        course.setStatus(AdCourseStatus.ACTIVE);
        plannerService.updateCourse(course);
        return new ResponseEntity<String>(course.getCode(), HttpStatus.OK);

    }

    @RequestMapping(value = "/courses/{code}/deactivate", method = RequestMethod.GET)
    public ResponseEntity<String> deactivateCourse(@PathVariable String code) {
        dummyLogin();
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
                plannerTransformer.toAcademicYearVos(plannerService.findAcademicYears(0, 100)), HttpStatus.OK);
    }

    // ====================================================================================================
    // CURRICULUM
    // ====================================================================================================

    @RequestMapping(value = "/curriculums", method = RequestMethod.GET)
    public ResponseEntity<List<Curriculum>> findCurriculums() {
        return new ResponseEntity<List<Curriculum>>(plannerTransformer.toCurriculumVos(plannerService.findCurriculums(0, 100)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/curriculums/{code}", method = RequestMethod.GET)
    public ResponseEntity<Curriculum> findCurriculumByCode(@PathVariable String code) {
        Curriculum curriculum = plannerTransformer.toCurriculumVo(plannerService.findCurriculumByCode(code));
        return new ResponseEntity<Curriculum>(curriculum, HttpStatus.OK);
    }

    @RequestMapping(value = "/curriculums/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveCurriculum(@PathVariable String code, @RequestBody Curriculum vo) {
        dummyLogin();
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
        curriculum.setSubjects(plannerService.findSubjects(curriculum));
        plannerService.saveCurriculum(curriculum);
        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @RequestMapping(value = "/curriculums/{code}/subjects", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> findSubjectsByCurriculum(@PathVariable String code) throws UnsupportedEncodingException {
        AdCurriculum curriculum = plannerService.findCurriculumByCode(code);
        List<AdSubject> subjects = plannerService.findSubjects(curriculum);
        return new ResponseEntity<List<Subject>>(plannerTransformer.toSubjectVos(subjects), HttpStatus.OK);
    }


    // ====================================================================================================
    // COHORT
    // ====================================================================================================

    @RequestMapping(value = "/cohorts", method = RequestMethod.GET)
    public ResponseEntity<List<Cohort>> findCohorts() {
        return new ResponseEntity<List<Cohort>>(plannerTransformer.toCohortVos(plannerService.findCohorts("%", 0, 100)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/cohorts/{code}", method = RequestMethod.GET)
    public ResponseEntity<Cohort> findCohortByCode(@PathVariable String code) throws UnsupportedEncodingException {
        return new ResponseEntity<Cohort>(plannerTransformer.toCohortVo(plannerService.findCohortByCode(code)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/cohorts/{code}/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveCohort(@PathVariable String code, @RequestBody Cohort vo) {
        dummyLogin();

        AdProgram program = plannerService.findProgramById(vo.getProgram().getId());
        AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
        AdCohort cohort = new AdCohortImpl();
        cohort.setCode(program.getCode() + "-" + academicSession.getCode());
        cohort.setDescription("Cohort for " + program.getCode());
        cohort.setProgram(program);
        cohort.setSession(academicSession);
        plannerService.saveCohort(cohort);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/cohorts/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCohort(@PathVariable String code, @RequestBody Cohort vo) {
        dummyLogin();

        AdCohort cohort = plannerService.findCohortByCode(code);
        cohort.setCode(vo.getCode());
        cohort.setDescription(vo.getDescription());
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

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subject> findSubjectById(@PathVariable Long id) {
        AdSubject subject = plannerService.findSubjectById(id);
        return new ResponseEntity<Subject>(plannerTransformer.toSubjectVo(subject), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/curriculums/{code}/singleSubjects", method = RequestMethod.POST)
    public ResponseEntity<String> addSingleSubject(@PathVariable Long id, @RequestBody SingleSubject vo) {
        dummyLogin();
        LOG.info("Haiii");
        AdCurriculum curriculum = plannerService.findCurriculumById(id);
        AdCourse course =  plannerService.findCourseByCode(vo.getCourse().getCode());
        AdSingleSubject subject = new AdSingleSubjectImpl();
     	subject.setCourse (course);
        subject.setOrdinal(vo.getOrdinal());
        subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
     	plannerService.addSubject(curriculum, subject);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
     	
    }
    
    @RequestMapping(value = "/curriculums/{code}/bundleSubjects", method = RequestMethod.POST)
    public ResponseEntity<String> addBundleSubject(@PathVariable Long id, @RequestBody BundleSubject vo) {
        dummyLogin();
        LOG.info("Haiii");
        AdCurriculum curriculum = plannerService.findCurriculumById(id);
        AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
        bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
        bundleSubject.setOrdinal(1);
        plannerService.addSubject(curriculum, bundleSubject);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
     	
    }

    @RequestMapping(value = "/curriculums/{code}/subject", method = RequestMethod.POST)
    public ResponseEntity<String> addSubject(@PathVariable Long id, @RequestBody Subject vo) {
        dummyLogin();
        LOG.info("Haiii");
        AdCurriculum curriculum = plannerService.findCurriculumById(id);
        AdSubject subject = new AdSubjectImpl();
        subject.setOrdinal(vo.getOrdinal());
        subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
        plannerService.addSubject(curriculum, subject);
    	
        if(vo.getSubjectType().ordinal() == 1) {
        	//bundle subject here
        	AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
            bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
            bundleSubject.setOrdinal(1);
            plannerService.addSubject(curriculum, bundleSubject);
        } else {
        	
        	//proced to single subject
        	 AdSingleSubject subject1 = new AdSingleSubjectImpl();
         	subject1.setCourse (plannerService.findCourseByCode(null));
             subject.setOrdinal(vo.getOrdinal());
             subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
         	plannerService.addSubject(curriculum, subject);
         	
        }
       /* AdSingleSubject subject1 = new AdSingleSubjectImpl();
    	subject1.setCourse (plannerService.findCourseByCode(null));
        subject.setOrdinal(vo.getOrdinal());
        subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
    	plannerService.addSubject(curriculum, subject);
    	
    	AdBundleSubject bundleSubject = new AdBundleSubjectImpl();
        bundleSubject.setSubjectType(AdSubjectType.CORE_ELECTIVE);
        bundleSubject.setOrdinal(1);
        plannerService.addSubject(curriculum, bundleSubject);
        */
       // AdBundleSubject addedBundleSubject = (AdBundleSubject)
      //  plannerService.findSubject(curriculum, AdSubjectType.CORE_ELECTIVE, 1);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody Subject vo) {
        dummyLogin();

        AdCurriculum curriculum = plannerService.findCurriculumById(id);
        AdSubject subject = plannerService.findSubjectById(id);
        subject.setOrdinal(vo.getOrdinal());
        subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
        plannerService.updateSubject(curriculum, subject);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }


    @RequestMapping(value = "/subjects/{id}/activate", method = RequestMethod.GET)
    public ResponseEntity<String> activateSubject(@PathVariable Long id, @RequestBody Subject vo) {
        dummyLogin();
        LOG.debug("activate subjects");
        AdCurriculum curriculum = plannerService.findCurriculumById(id);
        AdSubject subject = plannerService.findSubjectById(id);
        subject.setSubjectType(AdSubjectType.get(vo.getSubjectType().ordinal()));
        plannerService.updateSubject(curriculum, subject);
        return new ResponseEntity<String>("success", HttpStatus.OK);

    }

    @RequestMapping(value = "/subjects/{id}/deactivate", method = RequestMethod.GET)
    public ResponseEntity<String> deactivateSubject(@PathVariable Long id, @RequestBody Subject vo) {
        dummyLogin();
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

    private void dummyLogin() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
