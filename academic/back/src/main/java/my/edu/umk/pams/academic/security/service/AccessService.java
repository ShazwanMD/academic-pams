package my.edu.umk.pams.academic.security.service;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface AccessService {

    Set<AdPrincipal> findGrants(AdMetaObject object);

    Set<AdPrincipal> findGrants(AdMetaObject object, AdPermission permission);

    boolean checkPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission);

    void grantPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission);

    void inheritPermission(AdMetaObject parent, AdMetaObject object);

    void revokePermission(AdMetaObject object, AdPrincipal principal, AdPermission permission);

    boolean hasPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission);

    boolean hasPermission(AdMetaObject object, Authentication authentication, AdPermission permission);

    Integer countArchivedRecord(String filter, Date startDate, Date endDate, Class<?> aClass);

    Integer countArchivedRecord(String filter, AdFlowState flowType, Date startDate, Date endDate, Class<?> aClass);

    List<Long> findArchived(String filter, AdFlowState flowType, Date startDate, Date endDate, Class<?> aClass, Integer offset, Integer limit);
}
