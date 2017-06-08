package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdEnrollmentApplicationItem")
@Table(name = "AD_ENMT_APLN_ITEM")
public class AdEnrollmentApplicationItemImpl implements AdEnrollmentApplicationItem {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ENMT_APLN_ITEM")
    @SequenceGenerator(name = "SQ_AD_ENMT_APLN_ITEM", sequenceName = "SQ_AD_ENMT_APLN_ITEM", allocationSize = 1)
    private Long id;

    @Enumerated
    @Column(name = "ACTION")
    private AdEnrollmentApplicationAction action = AdEnrollmentApplicationAction.ADD;

    @ManyToOne(targetEntity = AdSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private AdSection section;

    @ManyToOne(targetEntity = AdEnrollmentApplicationImpl.class)
    @JoinColumn(name = "APPLICATION_ID")
    private AdEnrollmentApplication application;

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
    public AdEnrollmentApplicationAction getAction() {
        return action;
    }

    @Override
    public void setAction(AdEnrollmentApplicationAction action) {
        this.action = action;
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
    public AdEnrollmentApplication getApplication() {
        return application;
    }

    @Override
    public void setApplication(AdEnrollmentApplication application) {
        this.application = application;
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
        return AdEnrollmentApplicationItem.class;
    }
}
