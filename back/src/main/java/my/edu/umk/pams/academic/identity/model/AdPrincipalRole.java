package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdPrincipalRole extends AdMetaObject {

    AdPrincipal getPrincipal();

    void setPrincipal(AdPrincipal principal);

    AdRoleType getRole();

    void setRole(AdRoleType role);
}
