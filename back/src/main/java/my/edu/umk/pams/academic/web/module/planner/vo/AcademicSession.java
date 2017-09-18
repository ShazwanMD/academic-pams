package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.util.Date;

/**
 * @author PAMS
 */
public class AcademicSession extends MetaObject {

	private String code;
	private String description;
	private boolean current;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	// enroll
	private Date enrollStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date enrollEndDate;

	// admission
	private Date admissionStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date admissionEndDate;

	// graduation
	private Date graduationStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date graduationEndDate;

	private AcademicSemester semester;
	private AcademicYear year;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public Date getstartDate() {
		return startDate;
	}

	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getendDate() {
		return endDate;
	}

	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}

	// enroll start-end date
	public Date getEnrollStartDate() {
		return enrollStartDate;
	}

	public void setEnrollStartDate(Date enrollStartDate) {
		this.enrollStartDate = enrollStartDate;
	}

	public Date getEnrollEndDate() {
		return enrollEndDate;
	}

	public void setEnrollEndDate(Date enrollEndDate) {
		this.enrollEndDate = enrollEndDate;
	}

	// admission start-end date
	public Date getAdmissionStartDate() {
		return admissionStartDate;
	}

	public void setAdmissionStartDate(Date admissionStartDate) {
		this.admissionStartDate = admissionStartDate;
	}

	public Date getAdmissionEndDate() {
		return admissionEndDate;
	}

	public void setAdmissionEndDate(Date admissionEndDate) {
		this.admissionEndDate = admissionEndDate;
	}

	// graduation start-end date
	public Date getGraduationStartDate() {
		return graduationStartDate;
	}

	public void setGraduationStartDate(Date graduationStartDate) {
		this.graduationStartDate = graduationStartDate;
	}

	public Date getGraduationEndDate() {
		return graduationEndDate;
	}

	public void setGraduationEndDate(Date graduationEndDate) {
		this.graduationEndDate = graduationEndDate;
	}

	public AcademicSemester getSemester() {
		return semester;
	}

	public void setSemester(AcademicSemester academicSemester) {
		this.semester = academicSemester;
	}

	public AcademicYear getYear() {
		return year;
	}

	public void setYear(AcademicYear year) {
		this.year = year;
	}

}
