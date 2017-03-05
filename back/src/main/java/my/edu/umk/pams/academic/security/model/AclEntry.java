package my.edu.umk.pams.academic.security.model;

/**
 * @author canang technologies
 * @since 1/15/14
 */
public interface AclEntry {

    Long getId();

    Integer getAclOrder();

    Integer getMask();

    Boolean getGranting();

    Boolean getAuditSuccess();

    Boolean getAuditFailure();

    AclObjectIdentity getObjectIdentity();

    AclSid getSid();
}
