package my.edu.umk.pams.academic.core.model;

import my.edu.umk.pams.academic.core.AdFlowObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdDocument extends AdFlowObject {

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    String getSourceNo();

    void setSourceNo(String sourceNo);

    String getAuditNo();

    void setAuditNo(String auditNo);

    String getDescription();

    void setDescription(String description);

    String getRemoveComment();

    void setRemoveComment(String removeComment);

    String getCancelComment();

    void setCancelComment(String cancelComment);
}
