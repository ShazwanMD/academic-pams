package my.edu.umk.pams.academic.studyplan.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.dao.AdCurriculumDaoImpl;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicClassification;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdCourseImpl;
import my.edu.umk.pams.academic.studyplan.model.AdCurriculum;
import my.edu.umk.pams.academic.studyplan.model.AdCurriculumImpl;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

public class WhenIWantToSetUpCurriculumForAFaculty extends Stage<WhenIWantToSetUpCurriculumForAFaculty> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetUpCurriculumForAFaculty.class);

    @Autowired
    private StudyplanService studyplanService;

    @Autowired
    private CommonService commonService;  

    @ProvidedScenarioState
    private AdFaculty faculty;

    public WhenIWantToSetUpCurriculumForAFaculty I_want_to_set_up_curriculum_for_a_faculty_$(String code) {
    	
        faculty = studyplanService.findFacultyByCode(code);
        AdCurriculum Curriculum = new AdCurriculumImpl();
        
        Curriculum.setCode("");
        ((AdCourse) Curriculum).setFaculty(faculty);
        ((AdCourse) Curriculum).setClassification(AdAcademicClassification.LEVEL_000);
        Curriculum.getOrdinal();
        Curriculum.getPeriod();
        Curriculum.getProgram();
        studyplanService.adcurriculum(faculty, Curriculum);
        return self();
        
    }

}
