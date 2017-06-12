package my.edu.umk.pams.academic.web.module.planner.vo.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;

public class BundleSubjectPart extends MetaObject {
    private Course course;
    @JsonIgnore
    private BundleSubject bundle;

    public BundleSubject getBundle() {
        return bundle;
    }

    public void setBundle(BundleSubject bundle) {
        this.bundle = bundle;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
