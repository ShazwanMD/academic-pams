package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdProgram")
@Table(name = "AD_PRGM")
public class AdProgramImpl implements AdProgram {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_PRGM")
    @SequenceGenerator(name = "SQ_AD_PRGM", sequenceName = "SQ_AD_PRGM", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE_MS", nullable = false)
    private String titleMs;

    @Column(name = "TITLE_EN", nullable = false)
    private String titleEn;
    
    @Column(name = "STATUS", nullable = false)
    private AdProgramStatus status = AdProgramStatus.NEW;
    
    @ManyToOne(targetEntity = AdProgramLevelImpl.class)
    @JoinColumn(name = "LEVEL_ID")
    private AdProgramLevel programLevel;

    @ManyToOne(targetEntity = AdFacultyImpl.class)
    @JoinColumn(name = "FACULTY_ID")
    private AdFaculty faculty;

    @OneToMany(targetEntity = AdOfferingImpl.class, mappedBy = "program", fetch = FetchType.LAZY)
    private List<AdOffering> offerings;

    @Embedded
    private AdMetadata metadata;
    
    public AdProgramImpl() {
        setStatus(AdProgramStatus.NEW);
    }

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
    public AdProgramStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AdProgramStatus status) {
        this.status = status;
    }

    @Override
    public AdProgramLevel getLevel() {
        return programLevel;
    }

    @Override
    public void setLevel(AdProgramLevel level) {
        this.programLevel = level;
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
        return AdProgram.class;
    }
}
