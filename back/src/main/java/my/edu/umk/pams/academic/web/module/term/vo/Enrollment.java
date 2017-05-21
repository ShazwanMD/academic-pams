package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.web.module.common.vo.GradeCode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Enrollment extends MetaObject {

    private Section section;
    private Admission admission;
    //private GradeCode gradeCode;
   // private EnrollmentStanding standing = AdEnrollmentStanding.HW;
   // private EnrollmentStatus status = AdEnrollmentStatus.NEW;
    private EnrollmentStanding standing;
    private EnrollmentStatus status;

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
    
    public EnrollmentStanding getEnrollmentStanding() {
        return standing;
    }

    public void setEnrollmentStanding(EnrollmentStanding standing) {
        this.standing = standing;
    }
    
    public EnrollmentStatus getEnrollmentStatus() {
        return status;
    }

    public void setEnrollmentStatus(EnrollmentStatus status) {
        this.status = status;
    }
    
    /*public GradeCode getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(GradeCode gradeCode) {
        this.gradeCode = gradeCode;
    }*/


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
