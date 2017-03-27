package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdAudit extends AdMetaObject {

    String getMessage();

    void setMessage(String message);

    Long getUserId();

    void setUserId(Long userId);

    Long getObjectId();

    void setObjectId(Long objectId);

    String getClassName();

    void setClassName(String className);
}
