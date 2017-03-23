package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdCourse")
@Table(name = "AD_CRSE")
public class AdCourseImpl implements AdCourse {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CRSE")
    @SequenceGenerator(name = "SQ_AD_CRSE", sequenceName = "SQ_AD_CRSE", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TITLE_EN", nullable = false)
    private String titleEn;

    @Column(name = "TITLE_MS", nullable = false)
    private String titleMs;

    @Column(name = "CREDIT", nullable = false)
    private Integer credit = 0;

    @Column(name = "CLASSIFICATION", nullable = false)
    private AdAcademicClassification classification;

    @ManyToOne(targetEntity = AdFacultyImpl.class)
    @JoinColumn(name = "FACULTY_ID", nullable = false)
    private AdFaculty faculty;

    @OneToMany(targetEntity = AdCoursePrerequisiteImpl.class, mappedBy = "course", fetch = FetchType.LAZY)
    private List<AdCoursePrerequisite> prerequisites;

    @OneToMany(targetEntity = AdOfferingImpl.class, mappedBy = "course", fetch = FetchType.LAZY)
    private List<AdOffering> offerings;

    @Embedded
    private AdMetadata metadata;

    @Transient
    private boolean configured;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
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
    public String getTitleMs() {
        return titleMs;
    }

    @Override
    public void setTitleMs(String titleMs) {
        this.titleMs = titleMs;
    }

    @Override
    public Integer getCredit() {
        return credit;
    }

    @Override
    public void setCredit(Integer creditHour) {
        this.credit = creditHour;
    }

    @Override
    public AdAcademicClassification getClassification() {
        return classification;
    }

    @Override
    public void setClassification(AdAcademicClassification classification) {
        this.classification = classification;
    }

    @Override
    public AdFaculty getFaculty() {
        return faculty;
    }

    @Override
    public void setFaculty(AdFaculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public List<AdCoursePrerequisite> getPrerequisites() {
        return prerequisites;
    }

    @Override
    public void setPrerequisites(List<AdCoursePrerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public List<AdOffering> getOfferings() {
        return offerings;
    }

    @Override
    public void setOfferings(List<AdOffering> offerings) {
        this.offerings = offerings;
    }

    @Override
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdCourse.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdCourseImpl cngCourse = (AdCourseImpl) o;

        if (!id.equals(cngCourse.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AdCourseImpl{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}