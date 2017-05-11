package my.edu.umk.pams.academic;

/**
 * @author PAMS
 */
public interface AcademicConstants {

    public static final String ADMISSION_APPLICATION_REFERENCE_NO = "AdAdmissionApplication.referenceNo";
    public static final String ENROLLMENT_APPLICATION_REFERENCE_NO = "AdEnrollmentApplication.referenceNo";
	public static final String CHARGE_SCHEDULE_CODE = "AdChargeSchedule.code";
    public static final String STUDENT_MATRIC_NO = "AdStudent.matricNo";
    public static final String ADMISSION_APPLICATION_ID = "admissionApplicationId";
    public static final String ENROLLMENT_APPLICATION_ID = "enrollmentApplicationId";

    // workflow
	public static final String ADMISSION_APPLICATION_PROCESS_KEY = "admission_application_workflow";
	public static final String ADMISSION_APPLICATION_RESOURCE_PATH = "admission_application.bpmn20.xml";
	public static final String ADMISSION_APPLICATION_PROCESS_NAME = "admission_application";

	public static final String ENROLLMENT_APPLICATION_PROCESS_KEY = "enrollment_application_workflow";
	public static final String ENROLLMENT_APPLICATION_RESOURCE_PATH = "enrollment_application.bpmn20.xml";
	public static final String ENROLLMENT_APPLICATION_PROCESS_NAME = "enrollment_application";

	// configuration for startdate.open/close
	public static final String ENROLLMENT_STARTDATE_OPEN = "enrollment.startdate.open";
	public static final String ENROLLMENT_ENDDATE_CLOSE = "enrollment.enddate.close";
}
