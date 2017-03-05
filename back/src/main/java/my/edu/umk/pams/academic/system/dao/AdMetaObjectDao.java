package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 5/25/14
 */
public interface AdMetaObjectDao {

    AdMetaObject findMetaObjectById(Class clazz, Long id);
}
