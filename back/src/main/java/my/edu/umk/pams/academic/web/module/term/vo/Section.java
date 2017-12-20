package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.web.module.common.vo.StudyMode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Section extends MetaObject {

	private String code;
	private Integer capacity;
	private String canonicalCode;
	private Integer ordinal;
	private Offering offering;
	private StudyMode studyMode;

	// transient
	private Integer enrollmentCount;
	private Integer appointmentCount;
	private Integer sectionCount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getCanonicalCode() {
		return canonicalCode;
	}

	public void setCanonicalCode(String canonicalCode) {
		this.canonicalCode = canonicalCode;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public Integer getEnrollmentCount() {
		return enrollmentCount;
	}

	public void setEnrollmentCount(Integer enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public Integer getAppointmentCount() {
		return appointmentCount;
	}

	public void setAppointmentCount(Integer appointmentCount) {
		this.appointmentCount = appointmentCount;
	}

	public Integer getSectionCount() {
		return sectionCount;
	}

	public void setSectionCount(Integer sectionCount) {
		this.sectionCount = sectionCount;
	}

	public Offering getOffering() {
		return offering;
	}

	public void setOffering(Offering offering) {
		this.offering = offering;
	}
	
	public StudyMode getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(StudyMode studyMode) {
		this.studyMode = studyMode;
	}

	@JsonCreator
	public static Section create(String jsonString) {
		Section o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, Section.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}

}
