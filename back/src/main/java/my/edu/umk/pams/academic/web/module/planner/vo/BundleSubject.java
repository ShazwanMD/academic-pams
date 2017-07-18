package my.edu.umk.pams.academic.web.module.planner.vo;


import java.util.ArrayList;
import java.util.List;

public class BundleSubject extends Subject {
    private List<BundleSubjectPart> parts = new ArrayList<>();

    public void addPart(BundleSubjectPart part){
        parts.add(part);
    }

    public List<BundleSubjectPart> getParts() {
        return parts;
    }

    public void setParts(List<BundleSubjectPart> parts) {
        this.parts = parts;
    }

}
