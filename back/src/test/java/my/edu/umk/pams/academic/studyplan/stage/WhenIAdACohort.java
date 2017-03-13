package my.edu.umk.pams.academic.studyplan.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicClassification;
import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdCohortImpl;
import my.edu.umk.pams.academic.studyplan.model.AdCurriculum;
import my.edu.umk.pams.academic.studyplan.model.AdCurriculumImpl;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgramType;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIAdACohort extends Stage<WhenIAdACohort> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAdACohort.class);
	
	@Autowired
	private StudyplanService studyplanService;

	@Autowired
	private CommonService commonService;

	@ExpectedScenarioState
	private AdProgram program;
	
	public WhenIAdACohort I_want_to_set_up_cohort_for_$_faculty(String code) {
	    	
	    	program = studyplanService.findProgramByCode("MEM");
	        
	    	AdCurriculum curriculum = new AdCurriculumImpl();
	    	curriculum.setCode("01611B");
	    	curriculum.setCoreCredit(10);
	    	curriculum.setCurriculumCredit(10);
	    	curriculum.setTotalCredit(10);
	    	curriculum.setElectiveCredit(0);
	    	curriculum.setGeneralCredit(0);
	    	curriculum.setLanguageCredit(0);
	    	curriculum.setMaxPeriod(0);
	    	curriculum.setOrdinal(0);
	    	curriculum.setOthersCredit(0);
	    	curriculum.setPeriod(0);
	    	curriculum.setRequiredCredit(0);
	    	curriculum.setShortTitle("bagus");
	    	
	    	studyplanService.saveCurriculum(curriculum);
	    	
	        AdCohort cohort = new AdCohortImpl();
	        cohort.setCode("PRGM-1234");
	        cohort.setDescription("bahasa melayu");
	        cohort. setClassification(AdAcademicClassification.LEVEL_000 );
	        cohort. setCurriculum(curriculum);
	        cohort.setProgram(program);
	        studyplanService.saveProgram(program);
	        
	        
	        return self();

	}
}
