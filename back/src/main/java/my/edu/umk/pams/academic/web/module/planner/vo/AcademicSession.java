package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class AcademicSession extends MetaObject {
    private String code;
    private String description;
    private boolean current;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
