package my.edu.umk.pams.academic.web.module.planner.vo;

import java.util.List;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

public class Subject extends MetaObject {
	
	private Long id;
	private Integer ordinal;
	private SubjectType subjectType;
    private Curriculum curriculum;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getOrdinal() {
	     return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
	    this.ordinal = ordinal;
	    }
	
	 public SubjectType getsubjectType() {
	        return subjectType;
	    }

	    public void setSubjectType(SubjectType subjectType) {
	        this.subjectType = subjectType;
	    }
	    
	    public Curriculum getCurriculum() {
			return curriculum;
		}

		public void setCurriculum(Curriculum curriculum) {
			this.curriculum = curriculum;
		}
}
