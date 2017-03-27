package my.edu.umk.pams.academic.system.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdModule;
import my.edu.umk.pams.academic.system.model.AdSubModule;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface AdSubModuleDao extends GenericDao<Long, AdSubModule> {

    AdSubModule findByCode(String code);

    List<AdSubModule> find();

    List<AdSubModule> find(AdModule module, Integer offset, Integer limit);

    Integer count();

    Integer count(AdModule module);

    Integer count(String filter);

    boolean isExists(String code);
}
