package my.edu.umk.pams.academic.studyplan.stage;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain_zaida
 */

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.studyplan.model.AdCoursePrerequisiteImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIAddACoursePrerequisite extends Stage<WhenIAddACoursePrerequisite> {
	
	    @Autowired
	    private StudyplanService studyplanService;

	    @Autowired
	    private CommonService commonService;

	    @ProvidedScenarioState
	    private AdCourse course;
	
    public WhenIAddACoursePrerequisite I_want_add_course_prerequisite_$(String courseCode) {

    	course = studyplanService.findCourseByCode(courseCode);
    	AdCoursePrerequisite  prerequisites = new AdCoursePrerequisiteImpl();
    	prerequisites.setCourse(course);
    	prerequisites.setPrerequisite(course);
    	studyplanService.savePrerequisites(prerequisites);
    	
        return self();

    }

}
