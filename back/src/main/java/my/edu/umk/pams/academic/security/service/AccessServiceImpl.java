package my.edu.umk.pams.academic.security.service;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.security.dao.AclObjectIdentityDao;
import my.edu.umk.pams.academic.security.event.AccessEvent;
import my.edu.umk.pams.academic.security.integration.AdAclPermissionEvaluator;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import my.edu.umk.pams.academic.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Transactional
@Service("accessService")
public class AccessServiceImpl implements AccessService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private AclObjectIdentityDao aclObjectIdentityDao;

    @Autowired
    private AdAclPermissionEvaluator aclPermissionEvaluator;

    public Integer countAuthorizedObject(String filter, Class clazz, AdUser user) {
        return aclObjectIdentityDao.count(filter, clazz, retrieveSids(user));
    }

    public List<Long> findAuthorizedObject(String filter, Class clazz, AdUser user, Integer offset, Integer limit) {
        return aclObjectIdentityDao.find(filter, clazz, retrieveSids(user), offset, limit);
    }

    @Override
    public Set<AdPrincipal> findGrants(AdMetaObject object) {
        return aclObjectIdentityDao.findGrants(object);
    }

    @Override
    public Set<AdPrincipal> findGrants(AdMetaObject object, AdPermission permission) {
        return aclObjectIdentityDao.findGrants(object, permission);
    }

    @Override
    public boolean checkPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission) {
        return aclPermissionEvaluator.checkPermissionByProxy(principal, object, permission);
    }

    @Override
    public void grantPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission) {
        context.publishEvent(new AccessEvent(object, principal, permission, AccessEvent.Command.GRANT));
    }

    @Override
    public void inheritPermission(AdMetaObject parent, AdMetaObject object) {
        context.publishEvent(new AccessEvent(parent, object));
    }

    @Override
    public void revokePermission(AdMetaObject object, AdPrincipal principal, AdPermission permission) {
        context.publishEvent(new AccessEvent(object, principal, permission, AccessEvent.Command.REVOKE));
    }

    @Override
    public boolean hasPermission(AdMetaObject object, AdPrincipal principal, AdPermission permission) {
        if (null == object) return false;
        if (null == principal) return false;
        if (null == permission) return false;
        return aclPermissionEvaluator.checkPermissionByProxy(principal, object, permission);
    }

    @Override
    public boolean hasPermission(AdMetaObject object, Authentication authentication, AdPermission permission) {
        if (null == object) return false;
        if (null == authentication) return false;
        if (null == permission) return false;
        return aclPermissionEvaluator.hasPermission(authentication, object, permission);
    }

    @Override
    public Integer countArchivedRecord(String filter, Date startDate, Date endDate, Class<?> aClass) {
        return aclObjectIdentityDao.count(filter, aClass, identityService.findEffectiveGroupsAsString(Util.getCurrentUser()));
    }

    @Override
    public Integer countArchivedRecord(String filter, AdFlowState flowType, Date startDate, Date endDate, Class<?> aClass) {
        return aclObjectIdentityDao.count(filter, aClass, identityService.findEffectiveGroupsAsString(Util.getCurrentUser()));
    }

    @Override
    public List<Long> findArchived(String filter, AdFlowState flowType, Date startDate, Date endDate, Class<?> aClass, Integer offset, Integer limit) {
        return aclObjectIdentityDao.find(filter, aClass, identityService.findEffectiveGroupsAsString(Util.getCurrentUser()), offset, limit);
    }

    private Set<String> retrieveSids(AdUser user) {
        Set<String> sids = new HashSet<String>();
        List<AdGroup> groups = identityService.findImmediateGroups(user);
        for (AdGroup group : groups) {
            sids.add(group.getName());
        }
        sids.add(user.getName());
        return sids;
    }


}
