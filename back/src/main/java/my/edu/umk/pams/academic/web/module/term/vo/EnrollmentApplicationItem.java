package my.edu.umk.pams.academic.web.module.term.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class EnrollmentApplicationItem extends MetaObject {

    private EnrollmentApplicationAction action;
    private Section section;

    public EnrollmentApplicationAction getAction() {
        return action;
    }

    public void setAction(EnrollmentApplicationAction action) {
        this.action = action;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
