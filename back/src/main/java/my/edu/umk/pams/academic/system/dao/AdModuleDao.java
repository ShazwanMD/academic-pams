package my.edu.umk.pams.academic.system.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.system.model.AdModule;
import my.edu.umk.pams.academic.system.model.AdSubModule;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
public interface AdModuleDao extends GenericDao<Long, AdModule> {

    AdModule findByCode(String code);

    List<AdModule> find();

    Integer count(String filter);

    boolean isExists(String code);

    boolean isSubModuleExists(String code);

    void addSubModule(AdModule module, AdSubModule subModule, AdUser user);

    void updateSubModule(AdModule module, AdSubModule subModule, AdUser user);

    void removeSubModule(AdModule module, AdSubModule subModule, AdUser user);
}
