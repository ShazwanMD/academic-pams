package my.edu.umk.pams.academic.web.module.profile.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.common.vo.StudyMode;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.io.IOException;

/**
 * @author PAMS
 */
public class SwitchStudyMode {

    private AcademicSession academicSession;
    private StudyMode from;
    private StudyMode to;

    public StudyMode getFrom() {
        return from;
    }

    public void setFrom(StudyMode from) {
        this.from = from;
    }

    public StudyMode getTo() {
        return to;
    }

    public void setTo(StudyMode to) {
        this.to = to;
    }

    public AcademicSession getAcademicSession() {
        return academicSession;
    }

    public void setAcademicSession(AcademicSession academicSession) {
        this.academicSession = academicSession;
    }

    @JsonCreator
    public static SwitchStudyMode create(String jsonString) {
        SwitchStudyMode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, SwitchStudyMode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
