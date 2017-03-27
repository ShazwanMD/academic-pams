package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdUser;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdPrincipalDao extends GenericDao<Long, AdPrincipal> {

    // ====================================================================================================
    // HELPERS
    // ====================================================================================================

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdPrincipal findByName(String name);

    List<AdPrincipal> findAllPrincipals();

    List<AdPrincipal> find(String filter);

    List<AdPrincipal> find(String filter, AdPrincipalType type);

    List<AdPrincipal> find(String filter, Integer offset, Integer limit);

    void addRole(AdPrincipal principal, AdPrincipalRole principalRole, AdUser user);

    void deleteRole(AdPrincipal principal, AdPrincipalRole principalRole, AdUser user);

    Integer count(String filter);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

}
