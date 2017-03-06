package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AcSiteOffering")
@Table(name = "AD_SITE_OFRG")
public class AdSiteOfferingImpl implements AdSiteOffering {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_SITE_OFRG")
    @SequenceGenerator(name = "SQ_AD_SITE_OFRG", sequenceName = "SQ_AD_SITE_OFRG", allocationSize = 1)
    private Long id;


    @ManyToOne(targetEntity = AdSiteImpl.class)
    @JoinColumn(name = "SITE_ID", nullable = false)
    private AdSite site;

    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID", nullable = false)
    private AdProgram program;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdSite getSite() {
        return site;
    }

    public void setSite(AdSite site) {
        this.site = site;
    }

    public AdProgram getProgram() {
        return program;
    }

    public void setProgram(AdProgram program) {
        this.program = program;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdSiteOffering.class;
    }
}
