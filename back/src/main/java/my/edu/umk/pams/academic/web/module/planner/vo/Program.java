package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Program extends MetaObject{
    private String code;
    private String title;
    private String titleMs;
    private String titleEn;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleMs() {
        return titleMs;
    }

    public void setTitleMs(String titleMs) {
        this.titleMs = titleMs;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
