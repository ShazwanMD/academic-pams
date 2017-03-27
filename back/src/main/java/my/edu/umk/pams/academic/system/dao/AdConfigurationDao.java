package my.edu.umk.pams.academic.system.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdConfiguration;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdConfigurationDao extends GenericDao<Long, AdConfiguration> {

    AdConfiguration findByKey(String key);

    List<AdConfiguration> findByPrefix(String prefix);

    List<AdConfiguration> find(String filter, Integer offset, Integer limit);

    List<AdConfiguration> find(String filter);

    List<AdConfiguration> findInverse(String filter);

    Integer count(String filter);

}
