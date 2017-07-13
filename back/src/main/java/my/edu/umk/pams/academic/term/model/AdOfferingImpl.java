package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.planner.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdOffering")
@Table(name = "AD_OFRG")
public class AdOfferingImpl implements AdOffering {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_OFRG")
    @SequenceGenerator(name = "SQ_AD_OFRG", sequenceName = "SQ_AD_OFRG", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    // program.code/course.code
    @Column(name = "CANONICAL_CODE", nullable = false, unique = true)
    private String canonicalCode;

    @Column(name = "TITLE_MS", nullable = false)
    private String titleMs;

    @Column(name = "TITLE_EN", nullable = false)
    private String titleEn;

    @Column(name = "CAPACITY", nullable = false)
    private Integer capacity = 0;


    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @ManyToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private AdCourse course;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @OneToMany(targetEntity = AdSectionImpl.class, mappedBy = "offering", fetch = FetchType.LAZY)
    private List<AdSection> sections;

    @Embedded
    private AdMetadata metadata;

    // transient
    @Transient
    private Integer sectionCount = 0;

    @Transient
    private Integer assessmentCount = 0;
    
    @Transient
    private boolean isOfferingExist = true;


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

    @Override
    public String getCanonicalCode() {
        return canonicalCode;
    }

    @Override
    public void setCanonicalCode(String canonicalCode) {
        this.canonicalCode = canonicalCode;
    }

    @Override
    public String getTitleMs() {
        return titleMs;
    }

    @Override
    public void setTitleMs(String titleMs) {
        this.titleMs = titleMs;
    }

    @Override
    public String getTitleEn() {
        return titleEn;
    }

    @Override
    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Override
    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public AdProgram getProgram() {
        return program;
    }

    public void setProgram(AdProgram program) {
        this.program = program;
    }

    public AdCourse getCourse() {
        return course;
    }

    public void setCourse(AdCourse course) {
        this.course = course;
    }

    public AdAcademicSession getSession() {
        return session;
    }

    public void setSession(AdAcademicSession session) {
        this.session = session;
    }

    public List<AdSection> getSections() {
        return sections;
    }

    public void setSections(List<AdSection> sections) {
        this.sections = sections;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return null;
    }

    @Override
    public Integer getSectionCount() {
        return sectionCount;
    }

    @Override
    public void setSectionCount(Integer sectionCount) {
        this.sectionCount = sectionCount;
    }

    @Override
    public Integer getAssessmentCount() {
        return assessmentCount;
    }

    @Override
    public void setAssessmentCount(Integer assessmentCount) {
        this.assessmentCount = assessmentCount;
    }
    
    @Override
    public boolean getIsOfferingExist() {
        return isOfferingExist;
    }

    @Override
    public void setIsOfferingExist(boolean isOfferingExist) {
        this.isOfferingExist = isOfferingExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdOfferingImpl that = (AdOfferingImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AdOfferingImpl{" +
                "code='" + code + '\'' +
                '}';
    }

}
