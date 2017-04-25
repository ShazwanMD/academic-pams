package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.service.CommonService;

@JGivenStage
public class ThenGradeScaleUpdated extends Stage<ThenGradeScaleUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenGradeScaleUpdated.class);
	
	@Autowired 
	private CommonService commonService;
	
	@ExpectedScenarioState
	private AdGradeCode grade;
	
	public ThenGradeScaleUpdated grading_scale_updated() {
		
		LOG.debug(grade.getCode());
		List<AdGradeCode> grades =  commonService.findGradeCodes(grade);

		for (AdGradeCode grade: grades) {
			Assert.notNull(grade, "Grades must not be null");
			LOG.debug("View grade code: {}", grade.getCode());
			LOG.debug("View grade description", grade.getDescription());
			LOG.debug("CODE:{}", grade.getCode());
			LOG.debug("Description:{}", grade.getDescription());
			LOG.debug("");
		}
			
	
	
	
		return self();
		
	}

}
