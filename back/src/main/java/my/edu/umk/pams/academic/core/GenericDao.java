package my.edu.umk.pams.academic.core;


import my.edu.umk.pams.academic.identity.model.AdUser;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface GenericDao<K, I> {

    I newInstance();

    I refresh(I i);

    I findById(K k);

    List<I> find();

    List<I> find(Integer offset, Integer limit);
    
    List<I> findGraduatedStudents(Integer offset, Integer limit);

    List<I> findAuthorized(Set<String> sids);

    List<I> findAuthorized(Set<String> sids, Integer offset, Integer limit);

    List<Long> findAuthorizedIds(Set<String> sids);

    Integer count();

    Integer countAuthorized(Set<String> sids);

    void save(I entity, AdUser user);

    void saveOrUpdate(I entity, AdUser user);

    void update(I entity, AdUser user);

    void deactivate(I entity, AdUser user);

    void remove(I entity, AdUser user);

    void delete(I entity, AdUser user);
}
