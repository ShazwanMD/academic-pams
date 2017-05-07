package my.edu.umk.pams.academic.term.stage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;
/**
 * @author zaida_nawi
 **/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;


@JGivenStage
public class ThenTheDateEnrollmentIsReview extends Stage<ThenTheDateEnrollmentIsReview> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheDateEnrollmentIsReview.class);

	@Autowired
	private TermService termService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdSection section;
	
	
	@Autowired
	private SystemService systemService;

	public ThenTheDateEnrollmentIsReview Know_the_enrollment_interval_period() {
		
		AdConfiguration configurationOpen = systemService.findConfigurationByKey(AcademicConstants.ENROLLMENT_STARTDATE_OPEN);
		AdConfiguration configurationClose = systemService.findConfigurationByKey(AcademicConstants.ENROLLMENT_ENDDATE_CLOSE);
		
		String enrollOpen = configurationOpen.getValue();
		String enrollClose = configurationClose.getValue();
		
		LOG.debug("enrollOpen {}", enrollOpen);
		LOG.debug("enrollClose {}", enrollClose);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date openDate;
		Date closedDate;
			
		
		try {
			openDate = format.parse(enrollOpen);

			closedDate = format.parse(enrollClose);
			LOG.debug("Open Date :{}", openDate);
			LOG.debug("Closed Date :{}", closedDate);
			int interval = closedDate.getDate() - openDate.getDate();
			
			LOG.debug("Interval:{}", interval);
		
			//compare by date

			if(interval >= 9){
				
				LOG.debug("Status :{}",academicSession.getStatus().CLOSED);
			}else{
				LOG.debug("Status :{}",academicSession.getStatus().STARTED);
			}
		} catch (ParseException e) {
	
			e.printStackTrace();
		}

		
		//utk dapatkan date interval
		//1. convert string enrollOpen dan enrollClose kepada format date
		
		
		
		//AdOffering offering = termService.findOfferingByCanonicalCode("FIAT/MASTER/PBH/GST5023");
		
	   // Integer cntEnrollment = termService.countEnrollment(academicSession, offering);
		
	   // plannerService.countAvailableCourse(academicSession);
	   // LOG.debug("number of available course {} :", plannerService.countAvailableCourse(academicSession) );
	    //contoh count jum. course dlm academic session
	    
	    
	    
	    
//	    Integer countCourse(String filter);
//	    Integer countCourse(AdFaculty faculty);
//	    Integer countCourse(String filter, AdFaculty faculty);
//	    Integer countCourse(boolean authorized, String filter);
//	    Integer countAvailableCourse(AdAcademicSession academicSession);
		
	//	Assert.notNull(configuration, "section should be not null");

		
		
		
	return self();

	    }
	}


