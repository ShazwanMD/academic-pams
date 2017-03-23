package my.edu.umk.pams.academic.studyplan.stage;

import java.util.List;

import com.tngtech.jgiven.annotation.Pending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdCoursePrerequisite;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

/*
 * As an admin academic, 
 *  i want to set up  course prerequisite
 *    so that courses has a prerequisite
 * @author ain_zaida
 */

@JGivenStage
public class ThenCourseHasPrerequisite extends Stage<ThenCourseHasPrerequisite> {

	  @Autowired
	    private StudyplanService studyplanService;

	    @ExpectedScenarioState
	    private AdCourse course;

	    @Pending
	    public ThenCourseHasPrerequisite course_has_prerequisite() {
//	        List<AdCoursePrerequisite > prerequisites = studyplanService.findPrerequisites(course);
//	        Assert.notEmpty(prerequisites, "courseprerequisite should not be empty");
	        return self();

    }

}
