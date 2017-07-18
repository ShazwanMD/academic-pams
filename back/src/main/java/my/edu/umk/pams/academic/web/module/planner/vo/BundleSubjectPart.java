package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

public class BundleSubjectPart extends MetaObject {
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
