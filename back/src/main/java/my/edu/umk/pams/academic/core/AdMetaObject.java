package my.edu.umk.pams.academic.core;

import java.io.Serializable;

/**
 * @author canang technologies
 */
public interface AdMetaObject extends Serializable {

    /**
     * entity id
     *
     * @return
     */
    Long getId();

    /**
     * metadata
     *
     * @return
     */
    AdMetadata getMetadata();

    void setMetadata(AdMetadata metadata);

    /**
     * implementing interface
     *
     * @return
     */
    Class<?> getInterfaceClass();
}

