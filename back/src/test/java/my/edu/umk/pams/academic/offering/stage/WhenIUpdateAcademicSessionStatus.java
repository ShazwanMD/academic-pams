package my.edu.umk.pams.academic.offering.stage;
/**
 * @author asyikin.mr
 */
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.*;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class WhenIUpdateAcademicSessionStatus extends Stage<WhenIUpdateAcademicSessionStatus> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAcademicSessionStatus.class);

    @Autowired
    private StudyplanService studyplanService;

    @ProvidedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private String code;

    @ExpectedScenarioState
    private AdMetadata metadata;

    @ExpectedScenarioState
    private AdAcademicSession previous;

    public WhenIUpdateAcademicSessionStatus I_update_academic_session_status() {

        Calendar now = Calendar.getInstance();
        code = (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);
                
        academicSession = new AdAcademicSessionImpl();
        academicSession.setCode(code);
        academicSession.setCurrent(true);
        academicSession.setDescription("Sesi 09/2017/2018");
        academicSession.setMetadata(metadata);
        academicSession.setStatus(AdAcademicStatus.NEW);
        
        
        studyplanService.updateAcademicSession(academicSession);

        LOG.debug("academicSession {} ", academicSession);
        return self();
    }
}
