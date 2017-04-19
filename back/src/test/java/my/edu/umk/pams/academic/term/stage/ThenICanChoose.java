package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class ThenICanChoose extends Stage<ThenICanChoose> {

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private List<AdOffering> offerings;

	@ExpectedScenarioState
	private List<AdSection> sections;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdOffering offering;

	private static final Logger LOG = LoggerFactory.getLogger(ThenICanChoose.class);

	public ThenICanChoose i_can_choose_which_section_to_enroll() {

		program = offering.getProgram();
		LOG.debug("Offering program:{}",offering.getProgram().getTitle());
		offerings = termService.findOfferings(program);
		Assert.notNull(offerings, "offerings data is not null");

		for (AdOffering offering : offerings) {
			
			LOG.debug("=============Data Offering===================");
			LOG.debug("Offering CanonicalCode:{}",offering.getCanonicalCode());
			LOG.debug("Offering Code:{}",offering.getCode());
			LOG.debug("Offering Title:{}", offering.getTitle());
			LOG.debug("Offering Capacity: {}", offering.getCapacity());
			LOG.debug("Offering Course: {}", offering.getCourse().getTitle());
			LOG.debug("Offering Program: {}", offering.getProgram().getTitle());

			List<AdSection> sections = termService.findSections(offering);
			for (AdSection section : sections) {
				// check if section has exceeded capacity
				LOG.debug("section CanonicalCode:{}",section.getCanonicalCode());
				LOG.debug("section Capacity:{}",section.getCapacity());
				LOG.debug("section Session:{}",section.getSession().getDescription());
				
				boolean exceededEnrollment = termService.hasExceededEnrollment(section);
				Assert.isTrue(!exceededEnrollment, "Section is full");
			}
		}

		return self();

	}
}
