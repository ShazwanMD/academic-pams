package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */

@Component("plannerTransformer")
public class PlannerTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(PlannerTransformer.class);

    @Autowired
    private PlannerTransformer plannerTransformer;
    
    @Autowired
    private TermTransformer termTransformer;

    public AcademicSession toAcademicSessionVo(AdAcademicSession academicSession) {
        AcademicSession vo = new AcademicSession();
        vo.setId(academicSession.getId());
        vo.setCode(academicSession.getCode());
        vo.setDescription(academicSession.getDescription());
        vo.setCurrent(academicSession.isCurrent());
        vo.setstartDate(academicSession.getStartDate());
        vo.setendDate(academicSession.getEndDate());
        vo.setSemester(AcademicSemester.get(academicSession.getSemester().ordinal()));
        vo.setYear(plannerTransformer.toAcademicYearVo(academicSession.getYear()));
        return vo;
    }
    
    public AcademicYear toAcademicYearVo(AdAcademicYear academicYear) {
    	AcademicYear vo = new AcademicYear();
        vo.setId(academicYear.getId());
        vo.setCode(academicYear.getCode());
        vo.setDescription(academicYear.getDescription());
        vo.setYear(academicYear.getYear());
        return vo;
    }

    public StudyCenter toStudyCenterVo(AdStudyCenter studyCenter) {
        StudyCenter vo = new StudyCenter();
        vo.setId(studyCenter.getId());
        vo.setCode(studyCenter.getCode());
        vo.setDescription(studyCenter.getDescription());
        return vo;
    }

    public Faculty toFacultyVo(AdFaculty faculty) {
        Faculty vo = new Faculty();
        vo.setId(faculty.getId());
        vo.setCode(faculty.getCode());
        vo.setName(faculty.getName());
        vo.setDescription(faculty.getDescription());
        vo.setPrefix(faculty.getPrefix());
        vo.setStatus(FacultyStatus.get(faculty.getStatus().ordinal()));
        
        return vo;
    }
    public Program toProgramVo(AdProgram program) {
        Program vo = new Program();
        vo.setId(program.getId());
        vo.setCode(program.getCode());
        vo.setTitleMs(program.getTitleMs());
        vo.setTitleEn(program.getTitleEn());
        vo.setStatus(ProgramStatus.get(program.getStatus().ordinal()));
        vo.setFaculty(plannerTransformer.toFacultyVo(program.getFaculty()));
        vo.setLevel(plannerTransformer.toProgramLevelVo(program.getLevel()));
        return vo;
    }

    public ProgramLevel toProgramLevelVo(AdProgramLevel level) {
    	ProgramLevel vo = new ProgramLevel();
		vo.setId(level.getId());
        vo.setCode(level.getCode());
        vo.setDescription(level.getDescription());
        vo.setPrefix(level.getPrefix());
		return vo;
	}

	public Course toCourseVo(AdCourse course) {
        Course vo = new Course();
        vo.setId(course.getId());
        vo.setCode(course.getCode());
        vo.setTitleMs(course.getTitleMs());
        vo.setTitleEn(course.getTitleEn());
        vo.setCredit(course.getCredit());
        vo.setFaculty(plannerTransformer.toFacultyVo(course.getFaculty()));
        return vo;
    }

    public Cohort toCohortVo(AdCohort e) {
        Cohort vo = new Cohort();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        vo.setProgram(toProgramVo(e.getProgram()));
        vo.setAcademicSession(toAcademicSessionVo(e.getSession()));
        vo.setProgram(plannerTransformer.toProgramVo(e.getProgram()));
        vo.setClassification(AcademicClassification.get(e.getClassification().ordinal()));
        return vo;
    }
	public List<Cohort> toCohortVos(List<AdCohort> cohorts) {
        List<Cohort> vos = cohorts.stream()
                .map((cohort) -> toCohortVo(cohort))
                .collect(toList());
        return vos;
    }

	  public List<ProgramLevel> toProgramLevelVos(List<AdProgramLevel> programLevels) {
	        List<ProgramLevel> vos = programLevels.stream()
	        .map((programLevel) -> toProgramLevelVo(programLevel))
	        .collect(toList());
	        return vos;
	    }
	
    public List<StudyCenter> toStudyCenterVos(List<AdStudyCenter> studyCenters) {
        List<StudyCenter> vos = studyCenters.stream()
                .map((studyCenter) -> toStudyCenterVo(studyCenter))
                .collect(toList());
        return vos;
    }

    public List<AcademicSession> toAcademicSessionVos(List<AdAcademicSession> academicSessions) {
        List<AcademicSession> vos = academicSessions.stream()
                .map((academicSession) -> toAcademicSessionVo(academicSession))
                .collect(toList());
        return vos;
    }
    
    public List<AcademicYear> toAcademicYearVos(List<AdAcademicYear> academicYears) {
        List<AcademicYear> vos = academicYears.stream()
                .map((academicYear) -> toAcademicYearVo(academicYear))
                .collect(toList());
        return vos;
    }

    public List<Faculty> toFacultyVos(List<AdFaculty> faculties) {
        List<Faculty> vos = faculties.stream()
                .map((faculty) -> toFacultyVo(faculty))
                .collect(toList());
        return vos;
    }

    public List<Program> toProgramVos(List<AdProgram> programs) {
        List<Program> vos = programs.stream()
                .map((program) -> toProgramVo(program))
                .collect(toList());
        return vos;
    }

    public List<Course> toCourseVos(List<AdCourse> courses) {
        List<Course> vos = courses.stream()
                .map((course) -> toCourseVo(course))
                .collect(toList());
        return vos;
    }
}
