package my.edu.umk.pams.academic.web.module.planner.vo.subject;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Curriculum;

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

//    todo()
//    public SubjectType getSubjectType();
//    public void setSubjectType(SubjectType subjectType);
//    public AcademicPeriod getPeriod();
//    public void setPeriod(AcademicPeriod period);

    public Curriculum getCurriculum() {return curriculum;}

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
