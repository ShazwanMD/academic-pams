package my.edu.umk.pams.academic.web.module.term.vo;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class Gradebook {
    private BigDecimal score;
    private Assessment assessment;
    private Section section;
    private Enrollment enrollment;
    private Long id;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
    
    
}

