package my.edu.umk.pams.academic.identity.model;

import javax.persistence.*;
import java.util.Set;

import static my.edu.umk.pams.academic.identity.model.AdPrincipalType.GROUP;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdGroup")
@Table(name = "AD_GROP")
public class AdGroupImpl extends AdPrincipalImpl implements AdGroup {

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = AdPrincipalImpl.class)
    @JoinTable(name = "AD_GROP_MMBR", joinColumns = {
            @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "PRINCIPAL_ID",
                    nullable = false, updatable = false)})
    private Set<AdPrincipal> members;

    public AdGroupImpl() {
        setPrincipalType(GROUP);
    }

    public Set<AdPrincipal> getMembers() {
        return members;
    }

    public void setMembers(Set<AdPrincipal> members) {
        this.members = members;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdGroup.class;
    }

}
