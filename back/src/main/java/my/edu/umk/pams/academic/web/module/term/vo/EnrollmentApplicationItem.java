package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.term.vo.Section;

/**
 * @author PAMS
 */
public class EnrollmentApplicationItem extends MetaObject {

    private Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
