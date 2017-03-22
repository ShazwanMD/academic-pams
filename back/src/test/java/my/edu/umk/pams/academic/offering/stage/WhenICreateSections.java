package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.model.AdSectionImpl;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author asyikin.mr
 */
@JGivenStage
public class WhenICreateSections extends Stage<WhenICreateSections> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenICreateSections.class);

    @Autowired
    private OfferingService offeringService;

    @ProvidedScenarioState
    private AdSection section;

    @ProvidedScenarioState
    private AdCourse course;

    @ProvidedScenarioState
    private String canonicalCode;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdOffering offering;

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private String code;

    public WhenICreateSections I_create_sections_for_offering() {
        offering = offeringService.findOfferingByCanonicalCode("FIAT/PHD/0001");
        canonicalCode = faculty.getCode() + "/" + program.getCode() + "/" + academicSession.getCode();
        code = program.getCode() + "/" + academicSession.getCode();

        section = new AdSectionImpl();
        section.setCanonicalCode(canonicalCode);
        section.setCapacity(20);
        section.setCode(code);
        section.setSession(academicSession);
        section.setOffering(offering);
        offeringService.saveSection(section);
        ;

        return self();
    }
}
