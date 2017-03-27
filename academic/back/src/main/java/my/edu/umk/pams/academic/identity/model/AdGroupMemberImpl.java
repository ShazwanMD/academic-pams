package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdGroupMember")
@Table(name = "AD_GROP_MMBR")
public class AdGroupMemberImpl implements AdGroupMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_GROP_MMBR")
    @SequenceGenerator(name = "SQ_AD_GROP_MMBR", sequenceName = "SQ_AD_GROP_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = AdGroupImpl.class)
    @JoinColumn(name = "GROUP_ID")
    private AdGroup group;

    @OneToOne(targetEntity = AdPrincipalImpl.class)
    @JoinColumn(name = "PRINCIPAL_ID")
    private AdPrincipal principal;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdGroup getGroup() {
        return group;
    }

    public void setGroup(AdGroup group) {
        this.group = group;
    }

    public AdPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(AdPrincipal principal) {
        this.principal = principal;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdGroupMember.class;
    }


}
