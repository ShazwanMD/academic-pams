package my.edu.umk.pams.academic.system.model;

/**
 * @author canang.technologies
 * @since 7/26/14
 */
public interface AdWatch {

    Long getObjectId();

    void setObjectId(Long objectId);

    String getObjectClass();

    void setObjectClass(String objectClass);

    Long getUserId();

    void setUserId(Long userId);
}

