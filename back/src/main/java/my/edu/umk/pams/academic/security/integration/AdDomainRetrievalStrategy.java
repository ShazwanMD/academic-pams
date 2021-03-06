package my.edu.umk.pams.academic.security.integration;

import my.edu.umk.pams.academic.core.AdMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;

/**
 * @author canang technologies
 * @since 1/15/14
 */
public class AdDomainRetrievalStrategy implements ObjectIdentityRetrievalStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(AdDomainRetrievalStrategy.class);

    public ObjectIdentity getObjectIdentity(Object domainObject) {
        return new ObjectIdentityImpl(
                ((AdMetaObject) domainObject).getInterfaceClass(),
                ((AdMetaObject) domainObject).getId()
        );
    }
}
