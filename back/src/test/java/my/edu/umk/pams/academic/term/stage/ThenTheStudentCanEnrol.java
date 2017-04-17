/**
 * @author asyikin.mr

 */
package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenTheStudentCanEnrol extends Stage<ThenTheStudentCanEnrol> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheStudentCanEnrol.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private String canonicalCode;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenTheStudentCanEnrol the_student_can_enrol() {

		List<AdSection> sections = termService.findSections(academicSession);
		for (AdSection section : sections) {
			
			LOG.debug("==================view section ===============");
			LOG.debug("section CanonicalCode {} ", section.getCanonicalCode());
			LOG.debug("section Capacity {} ", section.getCapacity());
			LOG.debug("section Code {} ", section.getCode());

		}

		return self();
	}
}
