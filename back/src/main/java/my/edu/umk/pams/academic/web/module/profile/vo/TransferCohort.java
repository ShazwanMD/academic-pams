package my.edu.umk.pams.academic.web.module.profile.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.academic.web.module.planner.vo.Cohort;

import java.io.IOException;

/**
 * @author PAMS
 */
public class TransferCohort {

    private AcademicSession academicSession;
    private Cohort from;
    private Cohort to;

    public Cohort getFrom() {
        return from;
    }

    public void setFrom(Cohort from) {
        this.from = from;
    }

    public Cohort getTo() {
        return to;
    }

    public void setTo(Cohort to) {
        this.to = to;
    }

    public AcademicSession getAcademicSession() {
        return academicSession;
    }

    public void setAcademicSession(AcademicSession academicSession) {
        this.academicSession = academicSession;
    }

    @JsonCreator
    public static TransferCohort create(String jsonString) {
        TransferCohort o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, TransferCohort.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
