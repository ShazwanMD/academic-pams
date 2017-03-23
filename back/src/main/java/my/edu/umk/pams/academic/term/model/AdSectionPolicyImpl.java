package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdSectionPolicy")
@Table(name = "AD_SCTN_PLCY")
public class AdSectionPolicyImpl implements AdSectionPolicy {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_SCTN_PLCY")
    @SequenceGenerator(name = "SQ_AD_SCTN_PLCY", sequenceName = "SQ_AD_SCTN_PLCY", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = AdSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private AdSection section;

    @ManyToOne(targetEntity = AdFacultyImpl.class)
    @JoinColumn(name = "FACULTY_ID")
    private AdFaculty faculty;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public AdSection getSection() {
        return section;
    }

    @Override
    public void setSection(AdSection section) {
        this.section = section;
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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdSectionPolicy.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdSectionPolicyImpl cngSection = (AdSectionPolicyImpl) o;

        if (!id.equals(cngSection.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AdSectionPolicyImpl{" +
                "id=" + id +
                '}';
    }
}