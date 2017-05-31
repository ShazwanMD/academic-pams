package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.web.module.common.vo.StudyCenter;
import my.edu.umk.pams.academic.web.module.core.vo.Document;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;

import java.io.IOException;

/**
 * @author PAMS
 */
public class AdmissionApplication extends Document {

	private String auditNo;
	private String sourceNo;
	private String referenceNo;
	private String description;
	private String cancelComment;
	private String removeComment;
	private Student student;
    private AcademicSession session;
    private Program program;
    private StudyCenter studyCenter;
    private Staff advisor;


	public String getAuditNo() {
		return auditNo;
	}

	public void setAuditNo(String auditNo) {
		this.auditNo = auditNo;
	}

	public String getSourceNo() {
		return sourceNo;
	}

	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCancelComment() {
		return cancelComment;
	}

	public void setCancelComment(String cancelComment) {
		this.cancelComment = cancelComment;
	}

	public String getRemoveComment() {
		return removeComment;
	}

	public void setRemoveComment(String removeComment) {
		this.removeComment = removeComment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AcademicSession getSession() {
		return session;
	}

	public void setSession(AcademicSession session) {
		this.session = session;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public StudyCenter getStudyCenter() {
		return studyCenter;
	}

	public void setStudyCenter(StudyCenter studyCenter) {
		this.studyCenter = studyCenter;
	}
    
	public Staff getAdvisor(){
		return advisor;
	}

	public void setAdvisor(Staff advisor) {
		this.advisor = advisor;
	}


    @JsonCreator
    public static AdmissionApplication create(String jsonString) {
        AdmissionApplication o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, AdmissionApplication.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
