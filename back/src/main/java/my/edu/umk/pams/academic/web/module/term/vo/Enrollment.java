package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.web.module.common.vo.GradeCode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Enrollment extends MetaObject {

    private Student student;
    private Section section;
    private Admission admission;
    private GradeCode gradeCode;
    //private EnrollmentStanding standing = AdEnrollmentStanding.HW;
    //private EnrollmentStatus status = AdEnrollmentStatus.NEW;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }
    
    public GradeCode getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(GradeCode gradeCode) {
        this.gradeCode = gradeCode;
    }


    @JsonCreator
    public static Enrollment create(String jsonString) {
        Enrollment o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Enrollment.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
