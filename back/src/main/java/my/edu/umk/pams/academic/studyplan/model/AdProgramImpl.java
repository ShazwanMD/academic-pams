package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AcProgram")
@Table(name = "AD_PRGM")
public class AdProgramImpl implements AdProgram {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_PRGM")
    @SequenceGenerator(name = "SQ_AD_PRGM", sequenceName = "SQ_AD_PRGM", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "UPU_CODE", nullable = false, unique = true)
    private String upuCode;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TITLE_MS", nullable = false)
    private String titleMs;

    @Column(name = "TITLE_EN", nullable = false)
    private String titleEn;

    @Column(name = "PROGRAM_TYPE", nullable = false)
    private AdProgramType programType = AdProgramType.BACHELOR;

    @ManyToOne(targetEntity = AdFacultyImpl.class)
    @JoinColumn(name = "FACULTY_ID")
    private AdFaculty faculty;

    @OneToMany(targetEntity = AdOfferingImpl.class, mappedBy = "program", fetch = FetchType.LAZY)
    private List<AdOffering> offerings;

    @Embedded
    private AdMetadata metadata;

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
    public String getUpuCode() {
        return upuCode;
    }

    @Override
    public void setUpuCode(String upuCode) {
        this.upuCode = upuCode;
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
    public AdProgramType getProgramType() {
        return programType;
    }

    @Override
    public void setProgramType(AdProgramType programType) {
        this.programType = programType;
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
