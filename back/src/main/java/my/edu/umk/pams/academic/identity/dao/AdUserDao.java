package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdUser;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdUserDao extends GenericDao<Long, AdUser> {

    AdUser findByEmail(String email);

    AdUser findByUsername(String username);

    AdUser findByActor(AdActor actor);

    List<AdUser> find(String filter, Integer offset, Integer limit);

    List<AdGroup> findGroups(AdUser user);

    Integer count(String filter);

    boolean isExists(String username);

    boolean hasUser(AdActor actor);

}
