package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InPrincipal")
@Table(name = "AD_PCPL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AdPrincipalImpl implements AdPrincipal {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_PCPL")
    @SequenceGenerator(name = "SQ_AD_PCPL", sequenceName = "SQ_AD_PCPL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = true;

    @Column(name = "LOCKED", nullable = false)
    private boolean locked = false;

    @Column(name = "PRINCIPAL_TYPE")
    private AdPrincipalType principalType;

    @OneToMany(targetEntity = AdPrincipalRoleImpl.class, mappedBy = "principal", fetch = FetchType.EAGER)
    private Set<AdPrincipalRole> roles;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public AdPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(AdPrincipalType principalType) {
        this.principalType = principalType;
    }

    public Set<AdPrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AdPrincipalRole> roles) {
        this.roles = roles;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdPrincipalImpl that = (AdPrincipalImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdPrincipal.class;
    }

    @Override
    public String toString() {
        return "AdPrincipalImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", principalType=" + principalType +
                '}';
    }
}
