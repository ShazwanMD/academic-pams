package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.model.AdSectionPolicy;
import my.edu.umk.pams.academic.term.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

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

    @ProvidedScenarioState
    private AdOffering offering;

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private String code;
    
    @ProvidedScenarioState
    private List<AdAppointment> appointments;
    
    @ProvidedScenarioState
    private List<AdEnrollment> enrollments;
    
    @ProvidedScenarioState
    private List<AdSectionPolicy> policies;

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
        section.setAppointments(appointments);
        section.setAppointmentCount(1);
        section.setEnrollmentCount(1);
        section.setEnrollments(enrollments);
        section.setOrdinal(1);
        section.setPolicies(policies);
                     
        offeringService.saveSection(section);
        

        return self();
    }
}
