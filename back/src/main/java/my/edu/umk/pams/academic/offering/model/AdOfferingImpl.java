package my.edu.umk.pams.academic.offering.model;

import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AcOffering")
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

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CAPACITY", nullable = false)
    private Integer capacity = 0;


    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @ManyToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private AdCourse course;

    @OneToMany(targetEntity = AdSectionImpl.class, mappedBy = "offering", fetch = FetchType.LAZY)
    private List<AdSection> sections;

    @Embedded
    private AdMetadata metadata;

    // transient
    @Transient
    private Integer sectionCount = 0;

    @Transient
    private Integer assessmentCount = 0;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
