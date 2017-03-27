package my.edu.umk.pams.academic.security.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import my.edu.umk.pams.academic.security.model.AclObjectIdentity;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/31/14
 */
public interface AclObjectIdentityDao extends GenericDao<Long, AclObjectIdentity> {

    Set<AdPrincipal> findGrants(AdMetaObject object);

    Set<AdPrincipal> findGrants(AdMetaObject object, AdPermission permission);

    List<Long> find(String filter, Class clazz, Set<String> sids, Integer offset, Integer limit);

    Integer count(String filter, Class clazz, Set<String> sids);

}
