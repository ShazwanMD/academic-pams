package my.edu.umk.pams.academic.studyplan.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgramType;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIWantToViewTheProgramForEachLevelOfStudy extends Stage<WhenIWantToViewTheProgramForEachLevelOfStudy> {
	
	@Autowired
    private StudyplanService studyplanService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

	private String facultyCode;

	public WhenIWantToViewTheProgramForEachLevelOfStudy I_want_to_view_the_program_$_for_each_level_of_study(String string) {
		
		faculty = studyplanService.findFacultyByCode(facultyCode);
        Assert.notNull(faculty, "faculty CANNOT be null");

        AdProgram program = new AdProgramImpl();
        program.setCode("code");
        program.setFaculty(faculty);
        program.setProgramType(AdProgramType.PHD);
        program.setTitle("Master Business Administration ");
        program.setTitleEn("Master of Enterpreneurship (Management)");
        program.setTitleMs("Master of Enterpreneurship(Finance)");
        studyplanService.saveProgram(program);

       return self();
	}
	
	}
