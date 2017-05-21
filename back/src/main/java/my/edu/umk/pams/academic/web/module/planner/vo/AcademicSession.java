package my.edu.umk.pams.academic.web.module.planner.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;


/**
 * @author PAMS
 */
public class AcademicSession extends MetaObject {

    private String code;
    private String description;
    private boolean current;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a")
    private Date endDate;
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
