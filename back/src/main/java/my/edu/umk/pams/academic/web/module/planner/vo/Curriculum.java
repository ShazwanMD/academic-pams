package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.util.List;

/**
 * @author PAMS
 */
public class Curriculum extends MetaObject{
    private String code;
    private Integer coreCredit;
    private Integer curriculumCredit;
    private Integer electiveCredit;
    private Integer generalCredit;
    private Integer languageCredit;
    private Integer maxPeriod;
    private Integer ordinal;
    private Integer otherCredit;
    private Integer period;
    private Integer requiredCredit;
    private Integer totalCredit;
    private List<Subject> subjects;
    private Program program;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
  
    public Integer getCoreCredit() {
        return coreCredit;
    }

    public void setCoreCredit(Integer coreCredit) {
        this.coreCredit = coreCredit;
    }
    
    public Integer getCurriculumCredit() {
        return curriculumCredit;
    }

    public void setCurriculumCredit(Integer curriculumCredit) {
        this.curriculumCredit = curriculumCredit;
    }
    
    public Integer getElectiveCredit() {
        return electiveCredit;
    }

    public void setElectiveCredit(Integer electiveCredit) {
        this.electiveCredit = electiveCredit;
    }
    
    public Integer getGeneralCredit() {
        return generalCredit;
    }

    public void setGeneralCredit(Integer generalCredit) {
        this.generalCredit = generalCredit;
    }
    
    public Integer getLanguageCredit() {
        return languageCredit;
    }

    public void setLanguageCredit(Integer languageCredit) {
        this.languageCredit = languageCredit;
    }
    
    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
    }
    
    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
    
    public Integer getOtherCredit() {
        return otherCredit;
    }

    public void setOtherCredit(Integer otherCredit) {
        this.otherCredit = otherCredit;
    }
    
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
    
    public Integer getRequiredCredit() {
        return requiredCredit;
    }

    public void setRequiredCredit(Integer requiredCredit) {
        this.requiredCredit = requiredCredit;
    }
    
    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }
    
    
    @JsonCreator
    public static Curriculum create(String jsonString) {
        Curriculum o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Curriculum.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
