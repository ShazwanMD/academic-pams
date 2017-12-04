package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.common.model.AdCampus;
import my.edu.umk.pams.academic.common.model.AdCampusImpl;
import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdGraduateCenterImpl;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.common.model.AdStudyModeImpl;
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
    
    @Column(name = "PREFIX", nullable = true, length = 5)
    private String prefix;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "STATUS", nullable = false)
 	private AdFacultyStatus status = AdFacultyStatus.NEW;
    
    @OneToMany(targetEntity = AdProgramImpl.class, mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<AdProgram> programs;

    @OneToMany(targetEntity = AdCourseImpl.class, mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<AdCourse> courses;
    
	@OneToOne(targetEntity = AdGraduateCenterImpl.class)
	@JoinColumn(name = "GRADUATE_CENTER_ID", nullable = true)
	private AdGraduateCenter center;

	@ManyToOne(targetEntity = AdCampusImpl.class)
	@JoinColumn(name = "CAMPUS_ID", nullable = true)
	private AdCampus campus;

	
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

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
	
	@Override
	public AdFacultyStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(AdFacultyStatus status) {
        this.status = status;	
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
    
    public AdGraduateCenter getCenter() {
		return center;
	}

	public void setCenter(AdGraduateCenter center) {
		this.center = center;
	}

	public AdCampus getCampus() {
		return campus;
	}

	public void setCampus(AdCampus campus) {
		this.campus = campus;
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
