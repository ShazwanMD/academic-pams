package my.edu.umk.pams.academic.security.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.acls.domain.DefaultPermissionFactory;

/**
 * @author canang technologies
 * @since 1/13/14
 */
public class AdPermissionFactory extends DefaultPermissionFactory {

    private static final Logger log = LoggerFactory.getLogger(AdPermissionFactory.class);

    public AdPermissionFactory() {
        super(AdPermission.class);
        registerPublicPermissions(AdPermission.class);
    }
}
