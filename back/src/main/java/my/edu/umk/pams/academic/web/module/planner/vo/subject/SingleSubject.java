package my.edu.umk.pams.academic.web.module.planner.vo.subject;

import my.edu.umk.pams.academic.web.module.planner.vo.Course;

public class SingleSubject extends Subject {
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
