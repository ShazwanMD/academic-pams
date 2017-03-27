package my.edu.umk.pams.academic.system.event;

import my.edu.umk.pams.academic.system.dao.AdAuditDao;
import my.edu.umk.pams.academic.system.model.AdAudit;
import my.edu.umk.pams.academic.system.model.AdAuditImpl;
import my.edu.umk.pams.academic.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Transactional
@Component("auditListener")
public class AuditListener implements ApplicationListener<AuditEvent> {

    @Autowired
    private AdAuditDao auditDao;

    @Override
    public void onApplicationEvent(AuditEvent auditEvent) {
        AdAudit audit = new AdAuditImpl();
        audit.setClassName(auditEvent.getObject().getInterfaceClass().getCanonicalName());
        audit.setMessage(auditEvent.getMessage());
        audit.setObjectId(auditEvent.getObject().getId());
        audit.setUserId(Util.getCurrentUser().getId());
        auditDao.save(audit, Util.getCurrentUser());
    }
}
