package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Table(name = "AD_PCPL_ROLE")
@Entity(name = "AdPrincipalRole")
public class AdPrincipalRoleImpl implements AdPrincipalRole {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_PCPL_ROLE")
    @SequenceGenerator(name = "SQ_AD_PCPL_ROLE", sequenceName = "SQ_AD_PCPL_ROLE", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private AdRoleType role;

    @ManyToOne(targetEntity = AdPrincipalImpl.class)
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

    public AdRoleType getRole() {
        return role;
    }

    public void setRole(AdRoleType role) {
        this.role = role;
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
        return AdPrincipalRole.class;
    }

}
