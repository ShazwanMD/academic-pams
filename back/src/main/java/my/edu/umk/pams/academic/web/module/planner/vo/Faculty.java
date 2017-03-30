package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Faculty extends MetaObject{
    private String code;
    private String prefix;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
