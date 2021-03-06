package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import my.edu.umk.pams.academic.web.module.planner.vo.Subject;
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
        vo.setEnrollStartDate(academicSession.getEnrollStartDate());
        vo.setEnrollEndDate(academicSession.getEnrollEndDate());
        vo.setAdmissionStartDate(academicSession.getAdmissionStartDate());
        vo.setAdmissionEndDate(academicSession.getAdmissionEndDate());
        vo.setGraduationStartDate(academicSession.getGraduationStartDate());
        vo.setGraduationEndDate(academicSession.getGraduationEndDate());
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
        vo.setClassification(AcademicClassification.get(course.getClassification().ordinal()));
        vo.setCode(course.getCode());
        vo.setCredit(course.getCredit());
        vo.setTitleMs(course.getTitleMs());
        vo.setTitleEn(course.getTitleEn());
        vo.setFaculty(plannerTransformer.toFacultyVo(course.getFaculty()));
        vo.setStatus(CourseStatus.get(course.getStatus().ordinal()));
        return vo;
    }
      
    /*public List<Curriculum> toCurriculumVos(List<AdCurriculum> curriculums) {
        return curriculums.stream().map(this::toCurriculumVo).collect(toList());
    }*/

    public List<Curriculum> toCurriculumVos(List<AdCurriculum> curriculums) {
        List<Curriculum> vos = curriculums.stream()
                .map((curriculum) -> toCurriculumVo(curriculum))
                .collect(toList());
        return vos;
    }

    public Curriculum toCurriculumVo(AdCurriculum e) {
    	if(null == e)return null;
        Curriculum vo = new Curriculum();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setCoreCredit(e.getCoreCredit());
        vo.setCurriculumCredit(e.getCurriculumCredit());
        vo.setElectiveCredit(e.getElectiveCredit());
        vo.setGeneralCredit(e.getGeneralCredit());
        vo.setLanguageCredit(e.getLanguageCredit());
        vo.setOtherCredit(e.getOthersCredit());
        vo.setRequiredCredit(e.getRequiredCredit());
        vo.setTotalCredit(e.getTotalCredit());
        vo.setPeriod(e.getPeriod());
        vo.setMaxPeriod(e.getMaxPeriod());
        vo.setOrdinal(e.getOrdinal());
       // vo.setSubjects(plannerTransformer.toSubjectVos(e.getSubjects()));
        vo.setProgram(plannerTransformer.toProgramVo(e.getProgram()));
        return vo;
    }

    public List<Subject> toSubjectVos(List<AdSubject> subjects) {
        List<Subject> vos = subjects.stream()
                .map((subject) -> toSubjectVo(subject))
                .collect(toList());
        return vos;
    }
    
    public List<BundleSubjectPart> toBundleSubjectPartVos(List<AdBundleSubjectPart> subjectsParts) {
        List<BundleSubjectPart> vos = subjectsParts.stream()
                .map((subjectsPart) -> toBundleSubjectPartVo(subjectsPart))
                .collect(toList());
        return vos;
    }
    
    public BundleSubjectPart toBundleSubjectPartVo(AdBundleSubjectPart e) {
    	BundleSubjectPart vo = new BundleSubjectPart();
    	vo.setId(e.getId());
    	vo.setCourse(toCourseVo(e.getCourse()));
		return vo;
    }

    public Subject toSubjectVo(AdSubject subject) {
        Subject vo = null;
        if (subject instanceof AdSingleSubject) {
            vo = new SingleSubject();
            ((SingleSubject) vo).setCourse(toCourseVo(((AdSingleSubject) subject).getCourse()));
        } else if (subject instanceof AdBundleSubject) {
            vo = new BundleSubject();
            vo.setSubjectElectiveStatus(SubjectElectiveStatus.get(((AdBundleSubject) subject).getSubjectElectiveStatus().ordinal()));
            List<AdBundleSubjectPart> parts = ((AdBundleSubject) subject).getParts();
            for (AdBundleSubjectPart part : parts) {
                BundleSubjectPart partVo = new BundleSubjectPart();
                partVo.setCourse(toCourseVo(part.getCourse()));
                ((BundleSubject) vo).addPart(partVo);
            }
        }
        vo.setId(subject.getId());
        vo.setOrdinal(subject.getOrdinal());
        vo.setSubjectType(SubjectType.get(subject.getSubjectType().ordinal()));
        //vo.setCurriculum(toCurriculumVo(subject.getCurriculum()));
        vo.setCurriculum(plannerTransformer.toCurriculumVo(subject.getCurriculum()));
    
        return vo;
    }

    public Cohort toCohortVo(AdCohort e) {
    	if(null == e)return null;
        Cohort vo = new Cohort();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        vo.setProgram(toProgramVo(e.getProgram()));
        vo.setCurriculum(toCurriculumVo(e.getCurriculum()));
        vo.setAcademicSession(toAcademicSessionVo(e.getSession()));
        vo.setProgram(plannerTransformer.toProgramVo(e.getProgram()));
        vo.setCurriculum(plannerTransformer.toCurriculumVo(e.getCurriculum()));
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
