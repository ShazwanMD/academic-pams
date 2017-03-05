package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdPrincipal extends AdMetaObject {

    String getName();

    void setName(String name);

    AdPrincipalType getPrincipalType();

    void setPrincipalType(AdPrincipalType principalType);

    boolean isLocked();

    void setLocked(boolean locked);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    Set<AdPrincipalRole> getRoles();

    void setRoles(Set<AdPrincipalRole> roles);

}
