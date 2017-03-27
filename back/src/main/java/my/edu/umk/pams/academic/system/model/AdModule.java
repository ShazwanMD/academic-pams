package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface AdModule extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getCanonicalCode();

    void setCanonicalCode(String canonicalCode);

    String getDescription();

    void setDescription(String description);

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    boolean isEnabled();

    void setEnabled(boolean enabled);
}