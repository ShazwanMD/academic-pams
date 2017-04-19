package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdCohort")
@Table(name = "AD_CHRT")
public class AdCohortImpl implements AdCohort {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CHRT")
    @SequenceGenerator(name = "SQ_AD_CHRT", sequenceName = "SQ_AD_CHRT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CLASSIFICATION", nullable = false)
    private AdAcademicClassification classification;

    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @ManyToOne(targetEntity = AdCurriculumImpl.class)
    @JoinColumn(name = "CURRICULUM_ID")
    private AdCurriculum curriculum;
    
    @OneToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @Embedded
    private AdMetadata metadata;

    public AdCohortImpl() {
        setClassification(AdAcademicClassification.LEVEL_100);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AdAcademicClassification getClassification() {
        return classification;
    }

    public void setClassification(AdAcademicClassification classification) {
        this.classification = classification;
    }

    public AdProgram getProgram() {
        return program;
    }

    public void setProgram(AdProgram program) {
        this.program = program;
    }

    public AdCurriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(AdCurriculum curriculum) {
        this.curriculum = curriculum;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdCohort.class;
    }

	@Override
	public AdAcademicSession getSession() {
	
		return session;
	}

	@Override
	public void setSession(AdAcademicSession session) {
		this.session = session;
		
	}
}