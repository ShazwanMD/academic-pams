package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdGroupMember extends AdMetaObject {

    AdGroup getGroup();

    void setGroup(AdGroup group);

    AdPrincipal getPrincipal();

    void setPrincipal(AdPrincipal principal);
}
