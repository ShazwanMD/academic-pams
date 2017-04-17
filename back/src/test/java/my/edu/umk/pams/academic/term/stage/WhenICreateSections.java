/**
 * @author asyikin.mr
 */
package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
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
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenICreateSections extends Stage<WhenICreateSections> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenICreateSections.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

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

	@ProvidedScenarioState
	private String code;

	private String codeOffering;

	@ProvidedScenarioState
	private List<AdAppointment> appointments;

	@ProvidedScenarioState
	private List<AdEnrollment> enrollments;

	@ProvidedScenarioState
	private List<AdSectionPolicy> policies;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public WhenICreateSections I_create_sections_for_offering() {

		// Find faculty and program by passed value
		LOG.debug("Pick faculty: {}", faculty.getCode());
		LOG.debug("Pick program: {}", program.getCode());
		
		
	   		// List all offering course under program=A01/PHD/0001
			List<AdOffering> offerings = termService.findOfferings(program);
			for (AdOffering offering : offerings) {
				LOG.debug("Listed offering ID: {}", offering.getId());
				LOG.debug("Listed offering code: {}", offering.getCanonicalCode());
				
				canonicalCode = offering.getCanonicalCode() + "/" + academicSession.getCode() ;
				
				//get course code from ad_course
				code =	offering.getCourse().getCode(); 
				
				LOG.debug("canonicalCode: {}", canonicalCode);
				LOG.debug("code: {}", code);
				
				section = new AdSectionImpl();
				section.setCanonicalCode(canonicalCode);
				section.setCapacity(30);
				section.setCode(code);
				section.setOrdinal(1);
				section.setOffering(offering);
				section.setSession(academicSession);

				termService.saveSection(section);
				
				Assert.notNull(section, "new sections inserted");
				LOG.debug("===========NEW SECTION ADDED==========");
				LOG.debug("section: {}", section.getId());
			}

	   
		return self();
	}
}
