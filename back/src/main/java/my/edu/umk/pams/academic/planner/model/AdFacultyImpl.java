package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdFaculty")
@Table(name = "AD_FCTY")
public class AdFacultyImpl implements AdFaculty {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_FCTY")
    @SequenceGenerator(name = "SQ_AD_FCTY", sequenceName = "SQ_AD_FCTY", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;
    
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @OneToMany(targetEntity = AdProgramImpl.class, mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<AdProgram> programs;

    @OneToMany(targetEntity = AdCourseImpl.class, mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<AdCourse> courses;

    @Embedded
    private AdMetadata metadata;

    public AdFacultyImpl() {
    }

    public AdFacultyImpl(String code, String name) {
        this.code = code;
        this.name = name;
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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
        this.description = description;
    }

    public List<AdProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(List<AdProgram> programs) {
        this.programs = programs;
    }

    public List<AdCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<AdCourse> courses) {
        this.courses = courses;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdFaculty.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdFacultyImpl that = (AdFacultyImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
