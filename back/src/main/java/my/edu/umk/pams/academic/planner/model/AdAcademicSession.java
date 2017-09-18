package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.Date;

/**
 * STARTING<br/>
 * STARTED<br/>
 * CLOSING<br/>
 * CLOSED<br/>
 * 
 * @author PAMS
 */
public interface AdAcademicSession extends AdMetaObject {

	String getCode();

	void setCode(String code);

	String getDescription();

	void setDescription(String description);

	boolean isCurrent();

	void setCurrent(boolean current);

	Date getStartDate();

	void setStartDate(Date startDate);

	Date getEndDate();

	void setEndDate(Date endDate);

	AdAcademicStatus getStatus();

	void setStatus(AdAcademicStatus status);

	AdAcademicSession getPrevious();

	void setPrevious(AdAcademicSession previous);

	AdAcademicSemester getSemester();

	void setSemester(AdAcademicSemester academicSemester);

	AdAcademicYear getYear();

	void setYear(AdAcademicYear academicYear);

	// enroll start-end date
	Date getEnrollStartDate();

	void setEnrollStartDate(Date enrollStartDate);

	Date getEnrollEndDate();

	void setEnrollEndDate(Date enrollEndDate);

	// admission start-end date
	Date getAdmissionStartDate();

	void setAdmissionStartDate(Date admissionStartDate);

	Date getAdmissionEndDate();

	void setAdmissionEndDate(Date admissionEndDate);

	// graduation start-end date
	Date getGraduationStartDate();

	void setGraduationStartDate(Date graduationStartDate);

	Date getGraduationEndDate();

	void setGraduationEndDate(Date graduationEndDate);

	// transient
	public boolean isNew();

	public boolean isClosed();

	public boolean isStarted();

	public boolean isClosing();

	public boolean isStarting();

}
