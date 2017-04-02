/**
 * @author asyikin.mr
 */
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
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenICreateSections extends Stage<WhenICreateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenICreateSections.class);

	@Autowired
	private TermService termService;

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

	private String codeOffering;

	@ProvidedScenarioState
	private List<AdAppointment> appointments;

	@ProvidedScenarioState
	private List<AdEnrollment> enrollments;

	@ProvidedScenarioState
	private List<AdSectionPolicy> policies;

	public WhenICreateSections I_create_sections_for_offering() {
		offering = termService.findOfferingByCanonicalCode("MGSEB/MBA/GST 5013");
		//codeOffering = "DDA2113";
		canonicalCode = offering.getCanonicalCode() + "/" + academicSession.getCode(); //FKP/PHD/0001/DDA2113/201720181
		code = "GST 5013";

		section = new AdSectionImpl();
		section.setCanonicalCode(canonicalCode);
		section.setCapacity(20);
		section.setCode(code);
		section.setSession(academicSession);
		section.setOffering(offering);
		section.setOrdinal(1);

		termService.saveSection(section);

		return self();
	}
}
