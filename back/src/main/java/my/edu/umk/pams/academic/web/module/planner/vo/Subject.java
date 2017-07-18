package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleSubject.class, name = "single"),
        @JsonSubTypes.Type(value = BundleSubject.class, name = "bundle")
})
public class Subject extends MetaObject {

    private Integer ordinal;
    private SubjectType subjectType;
 
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
   
