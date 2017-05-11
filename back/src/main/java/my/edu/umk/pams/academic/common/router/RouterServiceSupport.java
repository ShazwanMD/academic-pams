package my.edu.umk.pams.academic.common.router;

import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.security.event.AccessEvent;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import my.edu.umk.pams.academic.system.service.SystemService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Abstract Router Service
 */
public class RouterServiceSupport implements ApplicationContextAware {

    @Autowired
    protected ApplicationContext context;

    @Autowired
    protected SystemService systemService;

    @Autowired
    protected IdentityService identityService;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    protected void publishAdcessEvent(AdDocument document, AdPrincipal principal, AdPermission read) {
        AccessEvent accessEvent = new AccessEvent(document, principal, AdPermission.VIEW);
        context.publishEvent(accessEvent);
    }
}
