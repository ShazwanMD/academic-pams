package my.edu.umk.pams.academic.web.module.term.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAMS
 */
public class GradebookMatrix {

    private Enrollment enrollment;
    private List<Gradebook> gradebooks = new ArrayList<>();

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public List<Gradebook> getGradebooks() {
        return gradebooks;
    }

    public void setGradebooks(List<Gradebook> gradebooks) {
        this.gradebooks = gradebooks;
    }

    public void addGradebook(Gradebook gradebook) {
        this.gradebooks.add(gradebook);
    }
}
