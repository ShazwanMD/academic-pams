package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenPrerequisiteRemove extends Stage<ThenPrerequisiteRemove> {


    public ThenPrerequisiteRemove prerequite_$_for_course_$_is_removed(String prereqCode, String courseCode) {

        //	todo (ain) The assertion(s)

        return self();
    }
}
