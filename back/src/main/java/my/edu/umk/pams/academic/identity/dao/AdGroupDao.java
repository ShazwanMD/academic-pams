package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdPrincipalType;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdGroupDao extends GenericDao<Long, AdGroup> {

    // ====================================================================================================
    // HELPERS
    // ====================================================================================================
    boolean hasMembership(AdGroup group, AdPrincipal principal);

    boolean isExists(String name);

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdGroup findByName(String name);

    List<AdGroup> findAll();

    List<AdGroup> findImmediate(AdPrincipal principal);

    List<AdGroup> findImmediate(AdPrincipal principal, Integer offset, Integer limit);

    Set<AdGroup> findEffectiveAsNative(AdPrincipal principal);

    List<AdGroup> findAvailableGroups(AdUser user);
    
    AdGroup findGroupByUser(AdUser user);

    List<AdPrincipal> findAvailableMembers(AdGroup group);

    List<AdPrincipal> findMembers(AdGroup group, AdPrincipalType principalType);

    List<AdPrincipal> findMembers(AdGroup group);

    List<AdPrincipal> findMembers(AdGroup group, Integer offset, Integer limit);

    List<AdGroup> find(String filter, Integer offset, Integer limit);

    List<AdGroup> findMemberships(AdPrincipal principal);

    Integer count(String filter);

    Integer countMember(AdGroup group);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addMember(AdGroup group, AdPrincipal member, AdUser user) throws RecursiveGroupException;

    void addMembers(AdGroup group, List<AdPrincipal> members, AdUser user) throws RecursiveGroupException;

    void deleteMember(AdGroup group, AdPrincipal member);

}
