package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.AdMetaObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author canang technologies
 * @since 5/25/14
 */
@SuppressWarnings({"unchecked"})
@Repository("metaObjectDao")
public class AdMetaObjectDaoImpl implements AdMetaObjectDao {

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    @Override
    public AdMetaObject findMetaObjectById(Class clazz, Long id) {
        return (AdMetaObject) sessionFactory.getCurrentSession().get(clazz, id);
    }
}
