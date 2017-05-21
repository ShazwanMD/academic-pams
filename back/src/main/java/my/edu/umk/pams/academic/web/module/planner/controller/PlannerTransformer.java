package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
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
    
    public AcademicSession toAcademicSessionVo(AdAcademicSession academicSession) {
        AcademicSession vo = new AcademicSession();
        vo.setId(academicSession.getId());
        vo.setCode(academicSession.getCode());
        vo.setDescription(academicSession.getDescription());
        vo.setCurrent(academicSession.isCurrent());
        vo.setstartDate(academicSession.getStartDate());
        vo.setendDate(academicSession.getEndDate());
        vo.setSemester(AcademicSemester.get(academicSession.getSemester().ordinal()));
        vo.setYear(toAcademicSessionVo (academicSession).getYear());
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
        return vo;
    }

    public Program toProgramVo(AdProgram program) {
        Program vo = new Program();
        vo.setId(program.getId());
        vo.setCode(program.getCode());
        vo.setTitle(program.getTitle());
        vo.setTitleMs(program.getTitleMs());
        vo.setTitleEn(program.getTitleEn());
        vo.setCurrent(program.isCurrent());
		vo.setFaculty(plannerTransformer.toFacultyVo(program.getFaculty()));
        return vo;
    }

    public Course toCourseVo(AdCourse course) {
        Course vo = new Course();
        vo.setId(course.getId());
        vo.setCode(course.getCode());
        vo.setTitle(course.getTitle());
        vo.setTitleMs(course.getTitleMs());
        vo.setTitleEn(course.getTitleEn());
        vo.setCredit(course.getCredit());
        vo.setFaculty(plannerTransformer.toFacultyVo(course.getFaculty()));
        
        return vo;
    }
    public Cohort toCohortVo(AdCohort cohort) {
        Cohort vo = new Cohort();
        vo.setId(cohort.getId());
        vo.setCode(cohort.getCode());
        vo.setDescription(cohort.getDescription());
        return vo;
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

    public List<Cohort> toCohortVos(List<AdCohort> cohorts) {
        List<Cohort> vos = cohorts.stream()
                .map((cohort) -> toCohortVo(cohort))
                .collect(toList());
        return vos;
    }
}
