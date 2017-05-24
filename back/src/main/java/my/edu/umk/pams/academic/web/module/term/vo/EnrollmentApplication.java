package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.Document;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.io.IOException;

/**
 * @author PAMS
 */
public class EnrollmentApplication extends Document {

	private String referenceNo;
	private String sourceNo;
	private String auditNo;
	private String description;
	private String removeComment;
	private String cancelComment;
	private Admission admission;
	private AcademicSession academicSession;
	private EnrollmentApplicationType enrollmentApplicationType;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getSourceNo() {
		return sourceNo;
	}

	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
	}

	public String getAuditNo() {
		return auditNo;
	}

	public void setAuditNo(String auditNo) {
		this.auditNo = auditNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemoveComment() {
		return removeComment;
	}

	public void setRemoveComment(String removeComment) {
		this.removeComment = removeComment;
	}

	public String getCancelComment() {
		return cancelComment;
	}

	public void setCancelComment(String cancelComment) {
		this.cancelComment = cancelComment;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public AcademicSession getAcademicSession() {
		return academicSession;
	}

	public void setAcademicSession(AcademicSession academicSession) {
		this.academicSession = academicSession;
	}

	public EnrollmentApplicationType getEnrollmentApplicationType() {
		return enrollmentApplicationType;
	}

	public void setEnrollmentApplicationType(EnrollmentApplicationType enrollmentApplicationType) {
		this.enrollmentApplicationType = enrollmentApplicationType;
	}

	@JsonCreator
	public static EnrollmentApplication create(String jsonString) {
		EnrollmentApplication o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, EnrollmentApplication.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}

}
