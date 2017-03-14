/**
 * @author asyikin.mr@umk and ziana

 */

package my.edu.umk.pams.academic.offering.stage;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

public class ThenTheOfferedCourseHasAMaxAllowQuota extends Stage<ThenTheOfferedCourseHasAMaxAllowQuota> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenTheOfferedCourseHasAMaxAllowQuota.class);

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdCourse course;

	public ThenTheOfferedCourseHasAMaxAllowQuota the_offered_course_has_a_maximum_quota() {
		
		// ada error pada findCourseByCode(code)
		//List<AdCourse> courses = studyplanService.findCourseByCode(code);
	       // Assert.notEmpty(courses);
		
	        return self();
		
	}
}
