package my.edu.umk.pams.academic.studyplan.stage;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain_zaida
 */

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIAddACoursePrerequisite extends Stage<WhenIAddACoursePrerequisite> {
	
	    @Autowired
	    private StudyplanService studyplanService;

	public WhenIAddACoursePrerequisite I_add_prereq_$_to_course_$(String courseCodePrereq, String courseCode) {

		AdCourse course = studyplanService.findCourseByCode(courseCode);
		AdCourse prereqCourse = studyplanService.findCourseByCode(courseCodePrereq);

    	studyplanService.addPrerequisites(course, prereqCourse);
    	
        return self();

    }

}
