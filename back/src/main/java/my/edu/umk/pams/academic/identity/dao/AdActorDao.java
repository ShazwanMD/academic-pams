package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorType;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdActorDao extends GenericDao<Long, AdActor> {

    AdActor findByCode(String code);

    AdActor findByIdentityNo(String identityNo);

    List<AdActor> find(String filter, Integer offset, Integer limit);

    List<AdActor> find(AdActorType type, Integer offset, Integer limit);

    List<AdActor> find(String filter, AdActorType type, Integer offset, Integer limit);

    Integer count(String filter);

    Integer count(String filter, AdActorType type);

    Integer count(AdActorType type);

    AdActor findByEmail(String email);
}
