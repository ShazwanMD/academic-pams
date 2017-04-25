package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;

@JGivenStage
public class WhenIAmUpdateGradeScale extends Stage<WhenIAmUpdateGradeScale> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateGradeScale.class);

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdGradeCode grade;

	public WhenIAmUpdateGradeScale i_setup_grading_scale() {

		// setup gradeCode
		AdGradeCode grade = new AdGradeCodeImpl();
		grade.setCode("A+");
		grade.setDescription("Cemerlang");
		grade.setOrdinal(0);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		AdGradeCode grade1 = new AdGradeCodeImpl();
		grade1.setCode("A");
		grade1.setDescription("Cemerlang");
		grade1.setOrdinal(1);
		commonService.saveGradeCode(grade1);

		LOG.debug("Grade:{}", grade1.getCode());
		LOG.debug("Desc:{}", grade1.getDescription());

		// setup gradeCode
		AdGradeCode grade2 = new AdGradeCodeImpl();
		grade2.setCode("A-");
		grade2.setDescription("KEPUJIAN");
		grade2.setOrdinal(2);
		commonService.saveGradeCode(grade2);

		LOG.debug("Grade:{}", grade2.getCode());
		LOG.debug("Desc:{}", grade2.getDescription());

		// setup gradeCode
		AdGradeCode grade3 = new AdGradeCodeImpl();
		grade3.setCode("B+");
		grade3.setDescription("KEPUJIAN");
		grade3.setOrdinal(3);
		commonService.saveGradeCode(grade3);

		LOG.debug("Grade:{}", grade3.getCode());
		LOG.debug("Desc:{}", grade3.getDescription());

		// setup gradeCode
		AdGradeCode grade4 = new AdGradeCodeImpl();
		grade4.setCode("B");
		grade4.setDescription("KEPUJIAN");
		grade4.setOrdinal(4);
		commonService.saveGradeCode(grade4);

		LOG.debug("Grade:{}", grade4.getCode());
		LOG.debug("Desc:{}", grade4.getDescription());

		// setup gradeCode
		AdGradeCode grade5 = new AdGradeCodeImpl();
		grade5.setCode("B-");
		grade5.setDescription("BAIK");
		grade5.setOrdinal(5);
		commonService.saveGradeCode(grade5);

		LOG.debug("Grade:{}", grade5.getCode());
		LOG.debug("Desc:{}", grade5.getDescription());

		// setup gradeCode
		AdGradeCode grade6 = new AdGradeCodeImpl();
		grade6.setCode("C");
		grade6.setDescription("LULUS");
		grade6.setOrdinal(6);
		commonService.saveGradeCode(grade6);

		LOG.debug("Grade:{}", grade6.getCode());
		LOG.debug("Desc:{}", grade6.getDescription());

		// setup gradeCode
		AdGradeCode grade7 = new AdGradeCodeImpl();
		grade7.setCode("C-");
		grade7.setDescription("LULUS BERSYARAT");
		grade7.setOrdinal(7);
		commonService.saveGradeCode(grade7);

		LOG.debug("Grade:{}", grade7.getCode());
		LOG.debug("Desc:{}", grade7.getDescription());

		// setup gradeCode
		AdGradeCode grade8 = new AdGradeCodeImpl();
		grade8.setCode("D");
		grade8.setDescription("LULUS BERSYARAT");
		grade8.setOrdinal(8);
		commonService.saveGradeCode(grade8);

		LOG.debug("Grade:{}", grade8.getCode());
		LOG.debug("Desc:{}", grade8.getDescription());

		// setup gradeCode
		AdGradeCode grade9 = new AdGradeCodeImpl();
		grade9.setCode("C+");
		grade9.setDescription("LULUS");
		grade9.setOrdinal(9);
		commonService.saveGradeCode(grade9);

		LOG.debug("Grade:{}", grade9.getCode());
		LOG.debug("Desc:{}", grade9.getDescription());

		// setup gradeCode
		AdGradeCode grade10 = new AdGradeCodeImpl();
		grade10.setCode("F");
		grade10.setDescription("GAGAL");
		grade10.setOrdinal(10);
		commonService.saveGradeCode(grade10);

		LOG.debug("Grade:{}", grade10.getCode());
		LOG.debug("Desc:{}", grade10.getDescription());
		LOG.debug("line dibawah ini adalah test update grading..");

		return self();
	}

	public WhenIAmUpdateGradeScale i_update_grading_scale() {

		// Test update 1
		grade = commonService.findGradeCodeByCode("A+");
		grade.setCode("A1");
		grade.setDescription("Test Update Grading A+ kpd A1");
		grade.setOrdinal(0);
		commonService.updateGradeCode(grade);

		LOG.debug("CODE:{}", grade.getCode());
		LOG.debug("Description:{}", grade.getDescription());
		LOG.debug("");

		// Test update 2
		grade = commonService.findGradeCodeByCode("A");
		grade.setCode("A2");
		grade.setDescription("Test Update Grading A kpd A2");
		grade.setOrdinal(1);
		commonService.updateGradeCode(grade);

		LOG.debug("CODE:{}", grade.getCode());
		LOG.debug("Description:{}", grade.getDescription());
		LOG.debug("");

		// Test update 3
		grade = commonService.findGradeCodeByCode("A-");
		grade.setCode("B1");
		grade.setDescription("Test Update Grading A- kpd B1");
		grade.setOrdinal(2);
		commonService.updateGradeCode(grade);

		LOG.debug("CODE:{}", grade.getCode());
		LOG.debug("Description:{}", grade.getDescription());
		LOG.debug("");

		// Test update 4
		grade = commonService.findGradeCodeByCode("B+");
		grade.setCode("B2");
		grade.setDescription("Test Update Grading B+ kpd B2");
		grade.setOrdinal(3);
		commonService.updateGradeCode(grade);

		LOG.debug("CODE:{}", grade.getCode());
		LOG.debug("Description:{}", grade.getDescription());
		LOG.debug("");

		return self();
	}

}
