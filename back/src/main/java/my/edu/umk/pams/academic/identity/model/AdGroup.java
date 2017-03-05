package my.edu.umk.pams.academic.identity.model;

import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdGroup extends AdPrincipal {

    // TODO: move to respective XxxConstants
    String GRP_USR = "UserGroup";
    String GRP_ADM_FIXED = "GRP_ADM_FIXED";
    String GRP_ADM_PURCHASE = "GRP_ADM_PURCHASE";
    String GRP_ADM_INVENTORY = "GRP_ADM_INVENTORY";

    Set<AdPrincipal> getMembers();

    void setMembers(Set<AdPrincipal> members);
}
