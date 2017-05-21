package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

public class AcademicYear extends MetaObject{
	
    private String code;
    private String description;
    private String year;
    
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
    
    
}
