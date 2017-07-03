package my.edu.umk.pams.academic.web.module.planner.vo.subject;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import my.edu.umk.pams.academic.planner.model.AdSubjectType;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Curriculum;
import my.edu.umk.pams.academic.web.module.planner.vo.SubjectType;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleSubject.class, name = "single"),
        @JsonSubTypes.Type(value = BundleSubject.class, name = "bundle")
})
public class Subject extends MetaObject {
    private Curriculum curriculum;
    private Integer ordinal;
    private SubjectType subjectType;
 
    public Curriculum getCurriculum() {
         return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
    
    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
    
    public SubjectType getSubjectType(){
    	return subjectType;
    }
    
    public void setSubjectType(SubjectType subjectType){
    this.subjectType = subjectType;
    	
    }
   
}
   
