package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component("plannerTransformer")
public class PlannerTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(PlannerTransformer.class);

    public AcademicSession toAcademicSessionVo(AdAcademicSession academicSession) {
        AcademicSession m = new AcademicSession();
        m.setId(academicSession.getId());
        m.setCode(academicSession.getCode());
        m.setDescription(academicSession.getDescription());
        return m;
    }

    public StudyCenter toStudyCenterVo(AdStudyCenter studyCenter) {
        StudyCenter m = new StudyCenter();
        m.setId(studyCenter.getId());
        m.setCode(studyCenter.getCode());
        m.setDescription(studyCenter.getDescription());
        return m;
    }

    public Faculty toFacultyVo(AdFaculty faculty) {
        Faculty m = new Faculty();
        m.setId(faculty.getId());
        m.setCode(faculty.getCode());
        m.setName(faculty.getName());
        return m;
    }

    public Program toProgramVo(AdProgram program) {
        Program m = new Program();
        m.setId(program.getId());
        m.setCode(program.getCode());
        m.setTitle(program.getTitle());
        m.setTitleMs(program.getTitleMs());
        m.setTitleEn(program.getTitleEn());
        return m;
    }

    public Course toCourseVo(AdCourse course) {
        Course m = new Course();
        m.setId(course.getId());
        m.setCode(course.getCode());
        m.setTitle(course.getTitle());
        m.setTitleMs(course.getTitleMs());
        m.setTitleEn(course.getTitleEn());
        m.setCredit(course.getCredit());
        return m;
    }

    public Cohort toCohortVo(AdCohort cohort) {
        Cohort m = new Cohort();
        m.setId(cohort.getId());
        m.setCode(cohort.getCode());
        return m;
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
