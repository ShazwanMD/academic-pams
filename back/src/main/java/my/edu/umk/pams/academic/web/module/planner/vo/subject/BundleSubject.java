package my.edu.umk.pams.academic.web.module.planner.vo.subject;


import java.util.List;

public class BundleSubject extends Subject {
    private List<BundleSubjectPart> parts;

    public List<BundleSubjectPart> getParts() {
        return parts;
    }

    public void setParts(List<BundleSubjectPart> parts) {
        this.parts = parts;
    }

}
